package com.personal.backoffice.business.process.create.rules;

import com.personal.backoffice.business.process.create.CreateBusinessProcess;
import com.personal.backoffice.system.factories.SystemServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class MigrateBusinessDataBaseRule implements IProcessRule<CreateBusinessProcess> {

    @Override
    public void apply(CreateBusinessProcess process) {

        var pLogger = LogFactory.builder(CreateBusinessProcess.class, MigrateBusinessDataBaseRule.class);

        var query = new Query();
        var dbName = process.Query().getParams().get("bss_db_name");
        query.Field("dbName", dbName);
        query.Field("migrate_location", "system.migration.client");

        var migrateDataBaseService = SystemServiceFactory.MigrateDataBaseService(dbName).create(query);

        if (migrateDataBaseService.getResult() != null) {
            process.addLog(pLogger.SUCCESS("Migrar Client Master Data Base", "Migración completada exitosamente!"));
        }

    }

}
