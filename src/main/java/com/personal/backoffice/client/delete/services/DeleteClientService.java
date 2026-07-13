package com.personal.backoffice.client.delete.services;

import java.util.Optional;

import com.personal.backoffice.client.notifications.ClientNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteClientService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("clients").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(ClientNotificationFactory.DeleteClientSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(ClientNotificationFactory.DeleteClientFail())
                    .get();
        }
        return builder.get();
    }

}
