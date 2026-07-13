package com.personal.business.user.filter.services;

import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.business.user.entities.User;
import com.personal.business.user.notifications.UserNotificationFactory;
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

        var userQuery = query.Select("users", "id").Get();

        try {

            var result = this.dbClient.get().execute()
                    .createQuery(userQuery)
                    .params(query.getParams())
                    .execute()
                    .map(
                            (dbRow) -> new User(dbRow.column("id").getString()))
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
