package com.personal.business.payrollrundeduction.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.business.payrollrundeduction.notifications.PayrollRunDeductionNotificationFactory;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayrollRun;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunDeductionService extends FilterService<PayrollRunDeduction> {

    public FilterPayrollRunDeductionService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<PayrollRunDeduction> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payroll_runs_deductions",
                "id", "business_id", "payroll_deductions_id", "payroll_runs_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map(dbRow -> EntityBuilder.Of(PayrollRunDeduction::new)
                    .With(PayrollRunDeduction::setId, dbRow.column("id").getString())
                    .With(PayrollRunDeduction::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(PayrollRunDeduction::setDeduction, new SharedDeduction(dbRow.column("payroll_deductions_id").getString()))
                    .With(PayrollRunDeduction::setPayrollRun, new SharedPayrollRun(dbRow.column("payroll_runs_id").getString()))
                    .With(PayrollRunDeduction::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(PayrollRunDeduction::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(PayrollRunDeduction::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(PayrollRunDeductionNotificationFactory.FetchPayrollRunDeductionSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollRunDeductionNotificationFactory.FetchPayrollRunDeductionFail());
        }

        return builder.get();
    }
}
