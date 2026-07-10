package com.personal.management.payrollbenefit.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.country.entities.Country;
import com.personal.management.payrollbenefit.entities.PayrollBenefit;
import com.personal.management.payrollbenefit.factories.PayrollBenefitResultFactory;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedPayroll;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollBenefitService implements IFilterService<PayrollBenefit> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<PayrollBenefit>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollBenefitResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_benefits",
                "id", "country_id", "business_benefits_id", "payrolls_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(PayrollBenefit::new)
                .With(PayrollBenefit::setId, dbRow.column("id").getString())
                .With(PayrollBenefit::setCountry, new Country(dbRow.column("country_id").getString()))
                .With(PayrollBenefit::setBenefit, new SharedBenefit(dbRow.column("business_benefits_id").getString()))
                .With(PayrollBenefit::setPayroll, new SharedPayroll(dbRow.column("payrolls_id").getString()))
                .With(PayrollBenefit::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(PayrollBenefit::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(PayrollBenefit::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollBenefitResultFactory.FetchNull();
        }

        return PayrollBenefitResultFactory.FetchResult(result);
    }
}
