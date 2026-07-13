package com.personal.backoffice.userrole.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.notifications.UserRoleNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterUserRoleService extends FilterService<UserRole> {

    public FilterUserRoleService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<UserRole> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("user_role",
                "id", "url_updated_at", "url_created_at", "url_created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(UserRole::new)
                    .With(UserRole::setId, dbRow.column("id").getString())
                    .With(UserRole::setCreatedAt, dbRow.column("url_created_at").get(LocalDateTime.class))
                    .With(UserRole::setUpdatedAt, dbRow.column("url_updated_at").get(LocalDateTime.class))
                    .With(UserRole::setCreatedBy, new User(dbRow.column("url_created_by").getString()))
                    .Get()).collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(UserRoleNotificationFactory.FetchUserRoleSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(UserRoleNotificationFactory.FetchUserRoleFail());
        }

        return builder.get();
    }
}
