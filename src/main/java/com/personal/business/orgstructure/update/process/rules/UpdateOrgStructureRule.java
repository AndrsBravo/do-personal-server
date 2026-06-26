package com.personal.business.orgstructure.update.process.rules;

import com.personal.business.orgstructure.factories.OrgStructureServiceFactory;
import com.personal.business.orgstructure.update.process.UpdateOrgStructureProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateOrgStructureRule implements IProcessRule<UpdateOrgStructureProcess> {

    @Override
    public void apply(UpdateOrgStructureProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgStructureProcess.class, UpdateOrgStructureRule.class);
        var orgStructure = process.getInitObject();
        var createOrgStructure = OrgStructureServiceFactory.EditOrgStructure(orgStructure.getBusiness().getDbName());
        var result = createOrgStructure.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Modificar Estructura de Organización", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Modificar Estructura de Organización", "La Estructura de Organización fue modificada exitosamente."));

    }

}
