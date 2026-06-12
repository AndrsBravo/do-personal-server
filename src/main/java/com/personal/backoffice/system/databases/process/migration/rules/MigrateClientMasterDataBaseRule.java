package com.personal.backoffice.system.databases.process.migration.rules;

import com.personal.backoffice.system.databases.process.migration.MigrationProcess;
import com.personal.backoffice.system.factories.SystemServiceFactory;
import com.personal.server.config.AppConfig;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class MigrateClientMasterDataBaseRule implements IProcessRule<MigrationProcess> {

    @Override
    public void apply(MigrationProcess process) {

        var pLogger = LogFactory.builder(MigrationProcess.class, MigrateClientMasterDataBaseRule.class);
        var query = process.Query();
        query.Field("dbName", AppConfig.get("system.db.client"));
        query.Field("migrate_location", "system.migration.client");

        var migrateDataBaseService = SystemServiceFactory.MigrateDataBaseService("client_master").create(query);

        if (migrateDataBaseService.getResult() != null) {
            process.addLog(pLogger.SUCCESS("Migrar Client Master Data Base", "Migración completada exitosamente!"));
        }

    }
}
