package com.personal.business.hierarchy.update.process.rules;

import com.personal.business.hierarchy.factories.HierarchyServiceFactory;
import com.personal.business.hierarchy.update.process.UpdateHierarchyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateHierarchyRule implements IProcessRule<UpdateHierarchyProcess> {

    @Override
    public void apply(UpdateHierarchyProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyProcess.class, UpdateHierarchyRule.class);
        var hierarchy = process.getInitObject();
        var createHierarchy = HierarchyServiceFactory.EditHierarchy(hierarchy.getBusiness().getDbName());
        var result = createHierarchy.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
