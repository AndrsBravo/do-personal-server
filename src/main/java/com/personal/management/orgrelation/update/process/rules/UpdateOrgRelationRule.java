package com.personal.management.orgrelation.update.process.rules;

import com.personal.management.orgrelation.factories.OrgRelationServiceFactory;
import com.personal.management.orgrelation.update.process.UpdateOrgRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateOrgRelationRule implements IProcessRule<UpdateOrgRelationProcess> {

    @Override
    public void apply(UpdateOrgRelationProcess process) {

        var pLogger = LogFactory.builder(UpdateOrgRelationProcess.class, UpdateOrgRelationRule.class);
        var createOrgRelation = OrgRelationServiceFactory.EditOrgRelation();
        var result = createOrgRelation.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
