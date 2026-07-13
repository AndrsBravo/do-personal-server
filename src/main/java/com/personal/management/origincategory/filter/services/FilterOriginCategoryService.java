package com.personal.management.origincategory.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.origincategory.entities.OriginCategory;
import com.personal.management.origincategory.notifications.OriginCategoryNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterOriginCategoryService extends FilterService<OriginCategory> {

    public FilterOriginCategoryService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<OriginCategory> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("origin_categories",
                "id", "co_origin", "co_title", "co_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(OriginCategory::new)
                    .With(OriginCategory::setId, dbRow.column("id").getString())
                    .With(OriginCategory::setOrigin, dbRow.column("co_origin").getString())
                    .With(OriginCategory::setTitle, dbRow.column("co_title").getString())
                    .With(OriginCategory::setDescription, dbRow.column("co_description").getString())
                    .With(OriginCategory::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(OriginCategory::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(OriginCategory::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(OriginCategoryNotificationFactory.FetchOriginCategorySuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(OriginCategoryNotificationFactory.FetchOriginCategoryFail());
        }

        return builder.get();
    }
}
