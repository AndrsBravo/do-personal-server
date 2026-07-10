package com.personal.business.payrollcalculation.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.business.payrollcalculation.factories.PayrollCalculationResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollCalculationService implements IFilterService<PayrollCalculation> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollCalculationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<PayrollCalculation>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollCalculationResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_calculations",
                "id", "payrolls_id", "business_id", "prc_title", "prc_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(PayrollCalculation::new)
                .With(PayrollCalculation::setId, dbRow.column("id").getString())
                .With(PayrollCalculation::setPayroll, new Payroll(dbRow.column("payrolls_id").getString()))
                .With(PayrollCalculation::setBusiness, new Business(dbRow.column("business_id").getString()))
                .With(PayrollCalculation::setTitle, dbRow.column("prc_title").getString())
                .With(PayrollCalculation::setDescription, dbRow.column("prc_description").getString())
                .With(PayrollCalculation::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(PayrollCalculation::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(PayrollCalculation::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollCalculationResultFactory.FetchNull();
        }

        return PayrollCalculationResultFactory.FetchResult(result);
    }
}
