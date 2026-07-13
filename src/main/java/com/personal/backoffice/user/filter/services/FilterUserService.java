package com.personal.backoffice.user.filter.services;

import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterUserService extends FilterService<User> {

    public FilterUserService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<User> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var userQuery = query.Select("users", "id", "us_email", "user_types_id", "user_name", "us_name", "us_last_name")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(userQuery)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(User::new)
                    .With(User::setId, dbRow.column("id").getString())
                    .With(User::setEmail, dbRow.column("us_email").getString())
                    .With(User::setUserName, dbRow.column("user_name").getString())
                    .With(User::setNames, dbRow.column("us_name").getString())
                    .With(User::setLastNames, dbRow.column("us_last_name").getString())
                    .Get()
                    )
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(UserNotificationFactory.FetchUserSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(UserNotificationFactory.FetchUserFail());
        }
        return builder.get();
    }
}
