package com.personal.backoffice.client.update.services;

import java.util.Optional;

import com.personal.backoffice.client.notifications.ClientNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditClientService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("clients").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(ClientNotificationFactory.CreateClientSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(ClientNotificationFactory.CreateClientFail());

        }
        return builder.get();
    }

}
