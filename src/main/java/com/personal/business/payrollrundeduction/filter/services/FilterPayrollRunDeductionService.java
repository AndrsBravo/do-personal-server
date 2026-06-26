package com.personal.business.payrollrundeduction.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.business.payrollrundeduction.factories.PayrollRunDeductionResultFactory;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayrollRun;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunDeductionService implements IFilterService<PayrollRunDeduction> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollRunDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<PayrollRunDeduction>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollRunDeductionResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_runs_deductions",
                "id", "business_id", "payroll_deductions_id", "payroll_runs_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map(dbRow
                        -> EntityBuilder.Of(PayrollRunDeduction::new)
                        .With(PayrollRunDeduction::setId, dbRow.column("id").getString())
                        .With(PayrollRunDeduction::setBusiness, new Business(dbRow.column("business_id").getString()))
                        .With(PayrollRunDeduction::setDeduction, new SharedDeduction(dbRow.column("payroll_deductions_id").getString()))
                        .With(PayrollRunDeduction::setPayrollRun, new SharedPayrollRun(dbRow.column("payroll_runs_id").getString()))
                        .With(PayrollRunDeduction::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                        .With(PayrollRunDeduction::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                        .With(PayrollRunDeduction::setCreatedBy, new User(dbRow.column("created_by").getString()))
                        .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollRunDeductionResultFactory.FetchNull();
        }

        return PayrollRunDeductionResultFactory.FetchResult(result);
    }
}
