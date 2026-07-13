package com.personal.backoffice.userrelation.delete.services;

import java.util.Optional;

import com.personal.backoffice.userrelation.notifications.UserRelationNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteUserRelationService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteUserRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("user_relation").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(UserRelationNotificationFactory.DeleteUserRelationSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(UserRelationNotificationFactory.DeleteUserRelationFail())
                    .get();
        }
        return builder.get();
    }

}
