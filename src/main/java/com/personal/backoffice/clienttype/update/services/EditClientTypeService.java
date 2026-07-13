package com.personal.backoffice.clienttype.update.services;

import java.util.Optional;

import com.personal.backoffice.clienttype.notifications.ClientTypeNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditClientTypeService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditClientTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("client_types").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(ClientTypeNotificationFactory.UpdateClientTypeSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(ClientTypeNotificationFactory.UpdateClientTypeFail());

        }
        return builder.get();
    }

}
