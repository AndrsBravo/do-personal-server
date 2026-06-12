package com.personal.business.orghierarchy.create.process.rules;

import com.personal.business.orghierarchy.create.process.CreateOrgHierarchyProcess;
import com.personal.business.orghierarchy.factories.OrgHierarchyServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateOrgHierarchyRule implements IProcessRule<CreateOrgHierarchyProcess> {

    @Override
    public void apply(CreateOrgHierarchyProcess process) {

        var pLogger = LogFactory.builder(CreateOrgHierarchyProcess.class, CreateOrgHierarchyRule.class);
        var orgHierarchy = process.getInitObject();
        var createOrgHierarchy = OrgHierarchyServiceFactory.CreateOrgHierarchy(orgHierarchy.getBusiness().getDbName());
        var result = createOrgHierarchy.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
