package com.personal.business.orgstructure.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.business.orgstructure.notifications.OrgStructureNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterOrgStructureService extends FilterService<OrgStructure> {

    public FilterOrgStructureService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<OrgStructure> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("organization_structures",
                "id", "orgs_structure", "orgs_title", "orgs_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(OrgStructure::new)
                    .With(OrgStructure::setId, dbRow.column("id").getString())
                    .With(OrgStructure::setLevel, dbRow.column("orgs_level").get(Short.class))
                    .With(OrgStructure::setStructure, dbRow.column("orgs_structure").getString())
                    .With(OrgStructure::setTitle, dbRow.column("orgs_title").getString())
                    .With(OrgStructure::setDescription, dbRow.column("orgs_description").getString())
                    .With(OrgStructure::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(OrgStructure::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(OrgStructure::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(OrgStructureNotificationFactory.FetchOrgStructureSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(OrgStructureNotificationFactory.FetchOrgStructureFail());
        }

        return builder.get();
    }
}
