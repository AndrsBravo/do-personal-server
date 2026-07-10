package com.personal.backoffice.system.databases.services;

import java.util.Optional;

import com.personal.backoffice.system.appdata.notifications.SystemNotificationsFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateDataBaseService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateDataBaseService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {

        //If not connection with db
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var createDataBaseQuery = "IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = '" + query.getParams().get("name") + "') BEGIN CREATE DATABASE " + query.getParams().get("name") + " END;";

        System.out.println("Query: " + createDataBaseQuery);
        System.out.println("Params: " + query.getParams());

        try {

            var records = dbClient.get().execute().dml(createDataBaseQuery);
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(SystemNotificationsFactory.CreateDataBaseSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(SystemNotificationsFactory.CreateDataBaseFail())
                    .get();
        }

    }

}
