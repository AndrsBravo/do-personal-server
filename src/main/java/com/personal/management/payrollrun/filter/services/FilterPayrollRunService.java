package com.personal.management.payrollrun.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.payroll.entities.Payroll;
import com.personal.management.payrollrun.entities.PayrollRun;
import com.personal.management.payrollrun.notifications.PayrollRunNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunService extends FilterService<PayrollRun> {

    public FilterPayrollRunService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<PayrollRun> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payroll_runs",
                "id", "payrolls_id", "prr_title", "prr_description", "payroll_runs_type_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(PayrollRun::new)
                    .With(PayrollRun::setId, dbRow.column("id").getString())
                    .With(PayrollRun::setPayroll, new Payroll(dbRow.column("payrolls_id").getString()))
                    .With(PayrollRun::setTitle, dbRow.column("prr_title").getString())
                    .With(PayrollRun::setDescription, dbRow.column("prr_description").getString())
                    .With(PayrollRun::setPayrollRunType, new TypeEntityBase(dbRow.column("payroll_runs_type_id").getString()))
                    .With(PayrollRun::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(PayrollRun::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(PayrollRun::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(PayrollRunNotificationFactory.FetchPayrollRunSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollRunNotificationFactory.FetchPayrollRunFail());
        }

        return builder.get();
    }
}
