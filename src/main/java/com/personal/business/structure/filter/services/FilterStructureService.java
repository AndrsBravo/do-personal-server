package com.personal.business.structure.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.notifications.StructureNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterStructureService extends FilterService<Structure> {

    public FilterStructureService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<Structure> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("business_structures",
                "id", "bss_structure", "bss_title", "bss_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(Structure::new)
                    .With(Structure::setId, dbRow.column("id").getString())
                    .With(Structure::setStructure, dbRow.column("bss_structure").getString())
                    .With(Structure::setTitle, dbRow.column("bss_title").getString())
                    .With(Structure::setDescription, dbRow.column("bss_description").getString())
                    .With(Structure::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(Structure::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(Structure::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(StructureNotificationFactory.FetchStructureSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(StructureNotificationFactory.FetchStructureFail());
        }

        return builder.get();
    }
}
