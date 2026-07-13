package com.personal.backoffice.usertype.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.usertype.notifications.UserTypeNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterUserTypeService extends FilterService<TypeEntityBase> {

    public FilterUserTypeService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<TypeEntityBase> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("user_types",
                "id", "ust_type", "ust_description", "ust_updated_at", "ust_created_at", "ust_created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow)
                            -> EntityBuilder.Of(TypeEntityBase::new)
                            .With(TypeEntityBase::setId, dbRow.column("id").getString())
                            .With(TypeEntityBase::setType, dbRow.column("ust_type").getString())
                            .With(TypeEntityBase::setDescription, dbRow.column("ust_description").getString())
                            .With(TypeEntityBase::setCreatedAt, dbRow.column("ust_created_at").get(LocalDateTime.class))
                            .With(TypeEntityBase::setUpdatedAt, dbRow.column("ust_updated_at").get(LocalDateTime.class))
                            .With(TypeEntityBase::setCreatedBy, new User(dbRow.column("ust_created_by").getString()))
                            .Get()
                    )
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(UserTypeNotificationFactory.FetchUserTypeSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(UserTypeNotificationFactory.FetchUserTypeFail());
        }

        return builder.get();
    }
}
