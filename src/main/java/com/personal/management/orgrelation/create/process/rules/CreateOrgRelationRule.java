package com.personal.management.orgrelation.create.process.rules;

import com.personal.management.orgrelation.create.process.CreateOrgRelationProcess;
import com.personal.management.orgrelation.factories.OrgRelationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateOrgRelationRule implements IProcessRule<CreateOrgRelationProcess> {

    @Override
    public void apply(CreateOrgRelationProcess process) {

        var pLogger = LogFactory.builder(CreateOrgRelationProcess.class, CreateOrgRelationRule.class);
        var createOrgRelation = OrgRelationServiceFactory.CreateOrgRelation();
        var result = createOrgRelation.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear Relación Organizacional", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear Relación Organizacional", "Relación Organizacional creada con éxito"));

    }

}
