package com.personal.backoffice.system.databases.process.migration.rules;

import com.personal.backoffice.system.databases.process.migration.MigrationProcess;
import com.personal.backoffice.system.factories.SystemServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateSystemMasterDataBaseRule implements IProcessRule<MigrationProcess> {

    @Override
    public void apply(MigrationProcess process) {

        LogFactory pLogger = LogFactory.builder(MigrationProcess.class, CreateSystemMasterDataBaseRule.class);
        String shouldDo = "Crear System Master Data Bases.";
        var query = process.Query();
        query.Field("name", "system_master");

        var dbExistsService = SystemServiceFactory.ExistsDataBaseService().get(query);

        if (dbExistsService.getResult() > 0) {
            process.addLog(pLogger.INFO(shouldDo, "system_master Data Base ya existe"));
            return;
        }

        var createDataBaseService = SystemServiceFactory.CreateDataBaseService().create(query);

        if (createDataBaseService.getResult() != null) {
            process.addLog(pLogger.SUCCESS(shouldDo, "system_master Data Base Created successfully!"));
        }

    }

}
