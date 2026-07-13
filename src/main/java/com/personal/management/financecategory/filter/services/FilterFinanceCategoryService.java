package com.personal.management.financecategory.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.management.financecategory.notifications.FinanceCategoryNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterFinanceCategoryService extends FilterService<FinanceCategory> {

    public FilterFinanceCategoryService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<FinanceCategory> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("finance_categories",
                "id", "fc_category", "fc_title", "fc_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(FinanceCategory::new)
                    .With(FinanceCategory::setId, dbRow.column("id").getString())
                    .With(FinanceCategory::setCategory, dbRow.column("fc_category").getString())
                    .With(FinanceCategory::setTitle, dbRow.column("fc_title").getString())
                    .With(FinanceCategory::setDescription, dbRow.column("fc_description").getString())
                    .With(FinanceCategory::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(FinanceCategory::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(FinanceCategory::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(FinanceCategoryNotificationFactory.FetchFinanceCategorySuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(FinanceCategoryNotificationFactory.FetchFinanceCategoryFail());
        }

        return builder.get();
    }
}
