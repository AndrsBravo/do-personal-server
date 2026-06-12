package com.personal.business.orgrelation.create.process.rules;

import com.personal.business.orgrelation.create.process.CreateOrgRelationProcess;
import com.personal.business.orgrelation.factories.OrgRelationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateOrgRelationRule implements IProcessRule<CreateOrgRelationProcess> {

    @Override
    public void apply(CreateOrgRelationProcess process) {

        var pLogger = LogFactory.builder(CreateOrgRelationProcess.class, CreateOrgRelationRule.class);
        var orgRelation = process.getInitObject();
        var createOrgRelation = OrgRelationServiceFactory.CreateOrgRelation(orgRelation.getBusiness().getDbName());
        var result = createOrgRelation.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
