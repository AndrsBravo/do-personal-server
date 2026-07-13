package com.personal.backoffice.clienttype.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.clienttype.notifications.ClientTypeNotificationFactory;
import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterClientTypeService extends FilterService<TypeEntityBase> {

    public FilterClientTypeService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<TypeEntityBase> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("client_types",
                "id", "ct_type", "ct_title", "ct_description", "ct_updated_at", "ct_created_at", "ct_created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow)
                            -> EntityBuilder.Of(TypeEntityBase::new)
                            .With(TypeEntityBase::setId, dbRow.column("id").getString())
                            .With(TypeEntityBase::setType, dbRow.column("ct_type").getString())
                            .With(TypeEntityBase::setTitle, dbRow.column("ct_title").getString())
                            .With(TypeEntityBase::setDescription, dbRow.column("ct_description").getString())
                            .With(TypeEntityBase::setCreatedAt, dbRow.column("ct_created_at").get(LocalDateTime.class))
                            .With(TypeEntityBase::setUpdatedAt, dbRow.column("ct_updated_at").get(LocalDateTime.class))
                            .With(TypeEntityBase::setCreatedBy, new User(dbRow.column("ct_created_by").getString()))
                            .Get()
                    )
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(ClientTypeNotificationFactory.FetchClientTypeSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(ClientTypeNotificationFactory.FetchClientTypeFail());
        }

        return builder.get();
    }
}
