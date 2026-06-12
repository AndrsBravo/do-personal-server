package com.personal.management.orgstructure.update.process.rules;

import com.personal.management.orgstructure.factories.OrgStructureServiceFactory;
import com.personal.management.orgstructure.update.process.UpdateOrgStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateOrgStructureRule implements IProcessRule<UpdateOrgStructureProcess> {

    @Override
    public void apply(UpdateOrgStructureProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgStructureProcess.class, UpdateOrgStructureRule.class);
        var createOrgStructure = OrgStructureServiceFactory.EditOrgStructure();
        var result = createOrgStructure.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
