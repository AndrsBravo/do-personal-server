package com.personal.business.orghierarchy.update.process.rules;

import com.personal.business.orghierarchy.factories.OrgHierarchyServiceFactory;
import com.personal.business.orghierarchy.update.process.UpdateOrgHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateOrgHierarchyRule implements IProcessRule<UpdateOrgHierarchyProcess> {

    @Override
    public void apply(UpdateOrgHierarchyProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgHierarchyProcess.class, UpdateOrgHierarchyRule.class);
        var orgHierarchy = process.getInitObject();
        var createOrgHierarchy = OrgHierarchyServiceFactory.EditOrgHierarchy(orgHierarchy.getBusiness().getDbName());
        var result = createOrgHierarchy.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
