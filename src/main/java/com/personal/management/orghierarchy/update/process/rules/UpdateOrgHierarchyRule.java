package com.personal.management.orghierarchy.update.process.rules;

import com.personal.management.orghierarchy.factories.OrgHierarchyServiceFactory;
import com.personal.management.orghierarchy.update.process.UpdateOrgHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateOrgHierarchyRule implements IProcessRule<UpdateOrgHierarchyProcess> {

    @Override
    public void apply(UpdateOrgHierarchyProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgHierarchyProcess.class, UpdateOrgHierarchyRule.class);
        var createOrgHierarchy = OrgHierarchyServiceFactory.EditOrgHierarchy();
        var result = createOrgHierarchy.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Modificar Jerarquía", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Modificar Jerarquía", "La Jerarquía ha sido modificada con éxito"));

    }

}
