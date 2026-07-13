package com.personal.backoffice.user.associateclient.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterAssociatedUserClientService extends FilterService<AssociateUserClient> {

    public FilterAssociatedUserClientService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<AssociateUserClient> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("user_has_clients",
                "id", "client_id", "users_id", "user_role_id", "user_relation_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow)
                            -> EntityBuilder.Of(AssociateUserClient::new)
                            .With(AssociateUserClient::setId, dbRow.column("id").getString())
                            .With(AssociateUserClient::setClient, new Client(dbRow.column("client_id").getString()))
                            .With(AssociateUserClient::setUser, new User(dbRow.column("users_id").getString()))
                            .With(AssociateUserClient::setUserRole, new UserRole(dbRow.column("user_role_id").getString()))
                            .With(AssociateUserClient::setUserRelation, new UserRelation(dbRow.column("user_relation_id").getString()))
                            .With(AssociateUserClient::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                            .With(AssociateUserClient::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                            .With(AssociateUserClient::setCreatedBy, new User(dbRow.column("created_by").getString()))
                            .Get()).collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(UserNotificationFactory.FetchAssociatedUserClientSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(UserNotificationFactory.FetchAssociatedUserClientFail());
        }
        return builder.get();
    }
}
