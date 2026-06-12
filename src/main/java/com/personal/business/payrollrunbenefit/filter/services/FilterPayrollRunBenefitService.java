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
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

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
                .map((dbRow) -> {
                    var payrollRunBenefit = new PayrollRunBenefit();
                    payrollRunBenefit.setId(dbRow.column("id").getString());
                    payrollRunBenefit.setBusiness(new Business(dbRow.column("business_id").getString()));
                    payrollRunBenefit.setBenefit(new SharedBenefit(dbRow.column("payroll_benefits_id").getString()));
                    payrollRunBenefit.setPayrollRun(new SharedPayrollRun(dbRow.column("payroll_runs_id").getString()));
                    payrollRunBenefit.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    payrollRunBenefit.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    payrollRunBenefit.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return payrollRunBenefit;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollRunBenefitResultFactory.FetchNull();
        }

        return PayrollRunBenefitResultFactory.FetchResult(result);
    }
}
