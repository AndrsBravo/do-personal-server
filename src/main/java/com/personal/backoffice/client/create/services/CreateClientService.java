package com.personal.backoffice.client.create.services;

import java.util.Optional;

import com.personal.backoffice.client.notifications.ClientNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateClientService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("clients").Get();

        //System.out.println(query.getParams());
        try {
            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(ClientNotificationFactory.CreateClientSuccess())
                    .get();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de empresa " + e.getMessage());
            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(ClientNotificationFactory.CreateClientFail())
                    .get();
        }
    }

}
