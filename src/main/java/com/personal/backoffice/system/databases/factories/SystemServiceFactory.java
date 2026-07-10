package com.personal.backoffice.system.databases.factories;

import com.personal.backoffice.system.databases.services.CreateDataBaseService;
import com.personal.backoffice.system.databases.services.ExistsDataBaseService;
import com.personal.backoffice.system.databases.services.MigrateDataBaseService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class SystemServiceFactory {

    public static CreateDataBaseService CreateDataBaseService() {

        return new CreateDataBaseService(DbClientMSSQLFactory.Master());
    }

    public static ExistsDataBaseService ExistsDataBaseService() {
        return new ExistsDataBaseService(DbClientMSSQLFactory.Master());
    }

    public static MigrateDataBaseService MigrateDataBaseService(String dbClient) {
        return new MigrateDataBaseService(DbClientMSSQLFactory.DbClient(dbClient));
    }
}
