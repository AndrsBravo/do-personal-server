package com.personal.business.hierarchy.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.notifications.HierarchyNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterHierarchyService extends FilterService<Hierarchy> {

    public FilterHierarchyService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<Hierarchy> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("business_hierarchies",
                "id", "bssh_hierarchy", "bssh_title", "bssh_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(Hierarchy::new)
                    .With(Hierarchy::setId, dbRow.column("id").getString())
                    .With(Hierarchy::setHierarchy, dbRow.column("bssh_hierarchy").getString())
                    .With(Hierarchy::setTitle, dbRow.column("bssh_title").getString())
                    .With(Hierarchy::setDescription, dbRow.column("bssh_description").getString())
                    .With(Hierarchy::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(Hierarchy::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(Hierarchy::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(HierarchyNotificationFactory.FetchHierarchySuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(HierarchyNotificationFactory.FetchHierarchyFail());
        }

        return builder.get();
    }
}
