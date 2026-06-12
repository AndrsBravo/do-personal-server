package com.personal.backoffice.system.databases.process.migration.rules;

import com.personal.backoffice.system.databases.process.migration.MigrationProcess;
import com.personal.backoffice.system.factories.SystemServiceFactory;
import com.personal.server.config.AppConfig;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class MigrateSystemMasterDataBaseRule implements IProcessRule<MigrationProcess> {

    @Override
    public void apply(MigrationProcess process) {

        var pLogger = LogFactory.builder(MigrationProcess.class, MigrateSystemMasterDataBaseRule.class);
        var query = process.Query();
        query.Field("dbName", AppConfig.get("system.db.master"));
        query.Field("migrate_location", "system.migration.system");

        var migrateDataBaseService = SystemServiceFactory.MigrateDataBaseService("system_master").create(query);

        if (migrateDataBaseService.getResult() != null) {
            process.addLog(pLogger.SUCCESS("Migrar Data Base System", "Migración completada exitosamente!"));
        }

    }

}
