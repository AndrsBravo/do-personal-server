package com.personal.backoffice.user.associateclient.delete.services;

import java.util.Optional;

import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteAssociatedUserClientService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteAssociatedUserClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("user_has_clients").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(UserNotificationFactory.DeleteAssociatedUserClientSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(UserNotificationFactory.DeleteAssociatedUserClientFail())
                    .get();
        }
        return builder.get();
    }

}
