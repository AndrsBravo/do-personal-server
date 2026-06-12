package com.personal.business.orgrelation.delete.process.rules;

import com.personal.business.orgrelation.delete.process.DeleteOrgRelationProcess;
import com.personal.business.orgrelation.factories.OrgRelationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteOrgRelationRule implements IProcessRule<DeleteOrgRelationProcess> {

    @Override
    public void apply(DeleteOrgRelationProcess process) {

        var pLogger = LogFactory.builder(DeleteOrgRelationProcess.class, DeleteOrgRelationRule.class);

        var query = process.Query();
        var orgRelation = process.getInitObject();

        query.Field("id", orgRelation.getId());
        query.Where().Equ("id");

        var createOrgRelation = OrgRelationServiceFactory.DeleteOrgRelation(orgRelation.getBusiness().getDbName());
        var result = createOrgRelation.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
