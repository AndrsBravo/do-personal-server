package com.personal.business.user.update.services;

import java.util.Optional;

import com.personal.business.user.notifications.UserNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditUserService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditUserService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var userQuery = query.Update("users").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(userQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(UserNotificationFactory.UpdateUserSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(UserNotificationFactory.UpdateUserFail());

        }
        return builder.get();

    }
}
