package com.personal.backoffice.userrelation.update.services;

import java.util.Optional;

import com.personal.backoffice.userrelation.notifications.UserRelationNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditUserRelationService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditUserRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("user_relation").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(UserRelationNotificationFactory.UpdateUserRelationSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(UserRelationNotificationFactory.UpdateUserRelationFail());

        }
        return builder.get();
    }

}
