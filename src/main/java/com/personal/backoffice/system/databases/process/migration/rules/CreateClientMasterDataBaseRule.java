package com.personal.backoffice.system.databases.process.migration.rules;

import com.personal.backoffice.system.databases.process.migration.MigrationProcess;
import com.personal.backoffice.system.factories.SystemServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateClientMasterDataBaseRule implements IProcessRule<MigrationProcess> {

    @Override
    public void apply(MigrationProcess process) {

        LogFactory pLogger = LogFactory.builder(MigrationProcess.class, CreateClientMasterDataBaseRule.class);
        String shouldDo = "Crear Client Master Data Bases.";
        var query = process.Query();
        query.Field("name", "client_master");

        var dbExistsService = SystemServiceFactory.ExistsDataBaseService().get(query);

        if (dbExistsService.getResult() > 0) {
            process.addLog(pLogger.INFO(shouldDo, "La base de datos Client Master ya existe"));
            return;
        }

        var createDataBaseService = SystemServiceFactory.CreateDataBaseService().create(query);

        if (createDataBaseService.getResult() != null) {
            process.addLog(pLogger.SUCCESS(shouldDo, "La Client Master Data Base fue creada exitosamente!"));
        }

    }

}
