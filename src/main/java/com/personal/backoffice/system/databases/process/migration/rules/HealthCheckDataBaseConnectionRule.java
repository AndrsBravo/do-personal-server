package com.personal.backoffice.system.databases.process.migration.rules;

import com.personal.backoffice.system.databases.process.migration.MigrationProcess;
import com.personal.backoffice.system.factories.SystemServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class HealthCheckDataBaseConnectionRule implements IProcessRule<MigrationProcess> {

    @Override
    public void apply(MigrationProcess process) {

        var pLogger = LogFactory.builder(MigrationProcess.class, HealthCheckDataBaseConnectionRule.class);

        process.Query().Field("name", "master");

        var dbExistsService = SystemServiceFactory.ExistsDataBaseService().get(process.Query());

        if (dbExistsService.getResult() > 0) {
            process.addLog(pLogger.INFO("Probando la conexión a la base de datos", "Conexión realizada correctamente!"));
            return;
        }

        process.addLog(pLogger.WARNING("Probando la conexión a la base de datos", "No se pudo establecer la conexión!"));
        process.stop();

    }

}
