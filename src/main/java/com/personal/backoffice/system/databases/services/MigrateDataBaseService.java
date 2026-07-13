package com.personal.backoffice.system.databases.services;

import java.util.Optional;

import com.personal.backoffice.system.appdata.notifications.SystemNotificationsFactory;
import com.personal.server.config.AppConfig;
import com.personal.server.flyway.FlyWayMigrationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class MigrateDataBaseService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public MigrateDataBaseService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult create(Query query) {

        var dbName = query.getParams().get("dbName");

        //If not connection with db
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        try {

            var migrate_location = AppConfig.get(query.getParams().get("migrate_location"));

            var result = FlyWayMigrationFactory.migrate(dbName, migrate_location);

            return ServiceResultBuilder.build()
                    .withRecords(Boolean.compare(result.success, false))
                    .withNotification(SystemNotificationsFactory.MigrateDataBaseSuccess())
                    .get();
        } catch (Exception e) {

            return ServiceResultBuilder.build()
                    .withException(e)
                    .withNotification(SystemNotificationsFactory.MigrateDataBaseFail())
                    .get();
        }

    }

}
