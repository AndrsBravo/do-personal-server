package com.personal.backoffice.system.databases.process.migration.rules;

import com.personal.backoffice.system.databases.factories.SystemServiceFactory;
import com.personal.backoffice.system.databases.process.migration.MigrationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateManagementDataBaseRule implements IProcessRule<MigrationProcess> {

    @Override
    public void apply(MigrationProcess process) {

        LogFactory pLogger = LogFactory.builder(MigrationProcess.class, CreateManagementDataBaseRule.class);
        String shouldDo = "Crear Management Data Bases.";
        var query = process.Query();
        query.Field("name", "management_db");

        var dbExistsService = SystemServiceFactory.ExistsDataBaseService().get(query);

        if (dbExistsService.getResult() > 0) {
            process.addLog(pLogger.INFO(shouldDo, "La base de datos Management ya existe"));
            return;
        }

        var createDataBaseService = SystemServiceFactory.CreateDataBaseService().create(query);

        if (createDataBaseService.getRecords() > 0) {
            process.addLog(pLogger.SUCCESS(shouldDo, "La Management Data Base fue creada exitosamente!"));
        }

    }

}
