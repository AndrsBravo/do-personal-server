package com.personal.backoffice.system.databases.process.migration.rules;

import com.personal.backoffice.system.databases.process.migration.MigrationProcess;
import com.personal.backoffice.system.factories.SystemServiceFactory;
import com.personal.server.config.AppConfig;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class MigrateManagementDataBaseRule implements IProcessRule<MigrationProcess> {

    @Override
    public void apply(MigrationProcess process) {

        var pLogger = LogFactory.builder(MigrationProcess.class, MigrateManagementDataBaseRule.class);

        var dbName = AppConfig.get("system.db.management");
        var query = process.Query();
        query.Field("dbName", dbName);
        query.Field("migrate_location", "system.migration.management");

        var migrateDataBaseService = SystemServiceFactory.MigrateDataBaseService(dbName).create(query);

        if (migrateDataBaseService.getResult() != null) {
            process.addLog(pLogger.SUCCESS("Migrar Management Data Base", "Migración completada exitosamente!"));
        }

    }
}
