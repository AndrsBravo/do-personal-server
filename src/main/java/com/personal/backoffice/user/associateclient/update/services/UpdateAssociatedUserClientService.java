package com.personal.backoffice.user.associateclient.update.services;

import java.util.Optional;

import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class UpdateAssociatedUserClientService implements IEditService {

    private final Optional<DbClient> dbClient;

    public UpdateAssociatedUserClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var userQuery = query.Update("user_has_clients").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(userQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(UserNotificationFactory.UpdateAssociatedUserClientSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(UserNotificationFactory.UpdateAssociatedUserClientFail());

        }
        return builder.get();
    }
}
