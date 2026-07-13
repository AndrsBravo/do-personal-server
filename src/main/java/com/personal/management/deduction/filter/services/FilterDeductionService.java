package com.personal.management.deduction.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.deduction.entities.Deduction;
import com.personal.management.deduction.notifications.DeductionNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterDeductionService extends FilterService<Deduction> {

    public FilterDeductionService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<Deduction> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("business_deductions",
                "id", "bd_deduction", "bd_title", "bd_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(Deduction::new)
                    .With(Deduction::setId, dbRow.column("id").getString())
                    .With(Deduction::setDeduction, dbRow.column("bd_deduction").getString())
                    .With(Deduction::setTitle, dbRow.column("bd_title").getString())
                    .With(Deduction::setDescription, dbRow.column("bd_description").getString())
                    .With(Deduction::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(Deduction::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(Deduction::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(DeductionNotificationFactory.FetchDeductionSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(DeductionNotificationFactory.FetchDeductionFail());
        }

        return builder.get();
    }
}
