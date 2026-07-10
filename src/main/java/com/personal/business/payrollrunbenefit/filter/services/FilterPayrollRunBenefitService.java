package com.personal.business.payrollrunbenefit.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.business.payrollrunbenefit.factories.PayrollRunBenefitResultFactory;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedPayrollRun;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunBenefitService implements IFilterService<PayrollRunBenefit> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollRunBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<PayrollRunBenefit>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollRunBenefitResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_runs_benefits",
                "id", "business_id", "payroll_benefits_id", "payroll_runs_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(PayrollRunBenefit::new)
                .With(PayrollRunBenefit::setId, dbRow.column("id").getString())
                .With(PayrollRunBenefit::setBusiness, new Business(dbRow.column("business_id").getString()))
                .With(PayrollRunBenefit::setBenefit, new SharedBenefit(dbRow.column("payroll_benefits_id").getString()))
                .With(PayrollRunBenefit::setPayrollRun, new SharedPayrollRun(dbRow.column("payroll_runs_id").getString()))
                .With(PayrollRunBenefit::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(PayrollRunBenefit::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(PayrollRunBenefit::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollRunBenefitResultFactory.FetchNull();
        }

        return PayrollRunBenefitResultFactory.FetchResult(result);
    }
}
