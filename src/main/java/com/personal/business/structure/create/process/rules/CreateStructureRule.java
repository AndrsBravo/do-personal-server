package com.personal.business.structure.create.process.rules;

import com.personal.business.structure.create.process.CreateStructureProcess;
import com.personal.business.structure.factories.StructureServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateStructureRule implements IProcessRule<CreateStructureProcess> {

    @Override
    public void apply(CreateStructureProcess process) {

        var pLogger = LogFactory.builder(CreateStructureProcess.class, CreateStructureRule.class);

        var structure = process.getInitObject();

        var createStructure = StructureServiceFactory.CreateStructure(structure.getBusiness().getDbName());
        var result = createStructure.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
