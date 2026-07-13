package com.personal.business.orghierarchy.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.business.orghierarchy.notifications.OrgHierarchyNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterOrgHierarchyService extends FilterService<OrgHierarchy> {

    public FilterOrgHierarchyService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<OrgHierarchy> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("organization_hierarchies",
                "id", "business_id", "orgh_hierarchy", "orgh_title", "orgh_description", "orgh_level", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(OrgHierarchy::new)
                    .With(OrgHierarchy::setId, dbRow.column("id").getString())
                    .With(OrgHierarchy::setLevel, dbRow.column("orgh_level").get(Short.class))
                    .With(OrgHierarchy::setHierarchy, dbRow.column("orgh_hierarchy").getString())
                    .With(OrgHierarchy::setTitle, dbRow.column("orgh_title").getString())
                    .With(OrgHierarchy::setDescription, dbRow.column("orgh_description").getString())
                    .With(OrgHierarchy::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(OrgHierarchy::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(OrgHierarchy::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(OrgHierarchy::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(OrgHierarchyNotificationFactory.FetchOrgHierarchySuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(OrgHierarchyNotificationFactory.FetchOrgHierarchyFail());
        }

        return builder.get();
    }
}
