package com.personal.backoffice.system.databases.services;

import java.util.Optional;

import com.personal.backoffice.system.entities.DataBase;
import com.personal.backoffice.system.factories.SystemResultFactory;
import com.personal.server.config.AppConfig;
import com.personal.server.flyway.FlyWayMigrationFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class MigrateDataBaseService implements ICreateService<DataBase> {

    private final Optional<DbClient> dbClient;

    public MigrateDataBaseService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<DataBase> create(Query query) {

        var dbName = query.getParams().get("dbName");

        //If not connection with db
        if (!dbClient.isPresent()) {
            return SystemResultFactory.MigrateDataBaseFail(dbName);
        }

        var migrate_location = AppConfig.get(query.getParams().get("migrate_location"));
        var result = FlyWayMigrationFactory.migrate(dbName, migrate_location);

        if (result.success) {
            return SystemResultFactory.DataBaseCreated(new DataBase(dbName));
        }

        return SystemResultFactory.MigrateDataBaseFail(dbName);

    }

}
