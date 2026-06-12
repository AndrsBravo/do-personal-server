package com.personal.business.orgstructure.create.process.rules;

import com.personal.business.orgstructure.create.process.CreateOrgStructureProcess;
import com.personal.business.orgstructure.factories.OrgStructureServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateOrgStructureRule implements IProcessRule<CreateOrgStructureProcess> {

    @Override
    public void apply(CreateOrgStructureProcess process) {

        var pLogger = LogFactory.builder(CreateOrgStructureProcess.class, CreateOrgStructureRule.class);
        var orgStructure = process.getInitObject();
        var createOrgStructure = OrgStructureServiceFactory.CreateOrgStructure(orgStructure.getBusiness().getDbName());
        var result = createOrgStructure.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
