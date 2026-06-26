package com.personal.business.payrolldeduction.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.payrolldeduction.entities.PayrollDeduction;
import com.personal.business.payrolldeduction.factories.PayrollDeductionResultFactory;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayroll;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollDeductionService implements IFilterService<PayrollDeduction> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<PayrollDeduction>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollDeductionResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_deductions",
                "id", "business_id", "business_deductions_id", "payrolls_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(PayrollDeduction::new)
                .With(PayrollDeduction::setId, dbRow.column("id").getString())
                .With(PayrollDeduction::setBusiness, new Business(dbRow.column("business_id").getString()))
                .With(PayrollDeduction::setDeduction, new SharedDeduction(dbRow.column("business_deductions_id").getString()))
                .With(PayrollDeduction::setPayroll, new SharedPayroll(dbRow.column("payrolls_id").getString()))
                .With(PayrollDeduction::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(PayrollDeduction::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(PayrollDeduction::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollDeductionResultFactory.FetchNull();
        }

        return PayrollDeductionResultFactory.FetchResult(result);
    }
}
