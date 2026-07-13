package com.personal.business.payroll.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payroll.notifications.PayrollNotificationFactory;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollService extends FilterService<Payroll> {

    public FilterPayrollService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<Payroll> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payrolls",
                "id", "pr_payroll", "pr_title", "pr_description", "temporal_frequency_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(Payroll::new)
                    .With(Payroll::setId, dbRow.column("id").getString())
                    .With(Payroll::setPayroll, dbRow.column("pr_payroll").getString())
                    .With(Payroll::setTitle, dbRow.column("pr_title").getString())
                    .With(Payroll::setDescription, dbRow.column("pr_description").getString())
                    .With(Payroll::setTemporalFrequency, new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()))
                    .With(Payroll::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(Payroll::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(Payroll::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(PayrollNotificationFactory.FetchPayrollSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollNotificationFactory.FetchPayrollFail());
        }

        return builder.get();
    }
}
