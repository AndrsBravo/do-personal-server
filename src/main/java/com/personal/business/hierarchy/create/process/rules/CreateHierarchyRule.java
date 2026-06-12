package com.personal.business.hierarchy.create.process.rules;

import com.personal.business.hierarchy.create.process.CreateHierarchyProcess;
import com.personal.business.hierarchy.factories.HierarchyServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateHierarchyRule implements IProcessRule<CreateHierarchyProcess> {

    @Override
    public void apply(CreateHierarchyProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyProcess.class, CreateHierarchyRule.class);
        var hierarchy = process.getInitObject();
        var createHierarchy = HierarchyServiceFactory.CreateHierarchy(hierarchy.getBusiness().getDbName());
        var result = createHierarchy.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
