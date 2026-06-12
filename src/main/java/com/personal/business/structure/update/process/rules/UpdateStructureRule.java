package com.personal.business.structure.update.process.rules;

import com.personal.business.structure.factories.StructureServiceFactory;
import com.personal.business.structure.update.process.UpdateStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateStructureRule implements IProcessRule<UpdateStructureProcess> {

    @Override
    public void apply(UpdateStructureProcess process) {

        var pLogger = LogFactory.builder(UpdateStructureProcess.class, UpdateStructureRule.class);
        var structure = process.getInitObject();
        var createStructure = StructureServiceFactory.EditStructure(structure.getBusiness().getDbName());
        var result = createStructure.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
