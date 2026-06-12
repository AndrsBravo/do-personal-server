package com.personal.backoffice.business.process.create.rules;

import com.personal.backoffice.business.process.create.CreateBusinessProcess;
import com.personal.backoffice.system.factories.SystemServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class CreateBusinessDataBaseRule implements IProcessRule<CreateBusinessProcess> {

    @Override
    public void apply(CreateBusinessProcess process) {

        var pLogger = LogFactory.builder(CreateBusinessProcess.class, CreateBusinessDataBaseRule.class);

        String shouldDo = "Crear base de datos de empresa.";

        var query = new Query();
        query.Field("name", process.Query().getParams().get("bss_db_name"));

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
