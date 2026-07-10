package com.personal.business.payrollcalculationresult.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.business.payrollcalculationresult.factories.PayrollCalculationResultResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollCalculationResultService implements IFilterService<PayrollCalculationResult> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollCalculationResultService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<PayrollCalculationResult>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollCalculationResultResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_calculations_results",
                "id", "payrolls_id", "business_id", "prcr_title", "ref_id", "ref_title", "prcr_quantity", "prcr_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(PayrollCalculationResult::new)
                .With(PayrollCalculationResult::setId, dbRow.column("id").getString())
                .With(PayrollCalculationResult::setPayroll, new Payroll(dbRow.column("payrolls_id").getString()))
                .With(PayrollCalculationResult::setBusiness, new Business(dbRow.column("business_id").getString()))
                .With(PayrollCalculationResult::setTitle, dbRow.column("prcr_title").getString())
                .With(PayrollCalculationResult::setReference, dbRow.column("ref_id").getString())
                .With(PayrollCalculationResult::setReferenceTitle, dbRow.column("ref_title").getString())
                .With(PayrollCalculationResult::setQuantity, dbRow.column("prcr_quantity").get(Double.class))
                .With(PayrollCalculationResult::setDescription, dbRow.column("prcr_description").getString())
                .With(PayrollCalculationResult::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(PayrollCalculationResult::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(PayrollCalculationResult::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollCalculationResultResultFactory.FetchNull();
        }

        return PayrollCalculationResultResultFactory.FetchResult(result);
    }
}
