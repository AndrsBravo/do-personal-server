package com.personal.business.orgstructure.delete.process.rules;

import com.personal.business.orgstructure.delete.process.DeleteOrgStructureProcess;
import com.personal.business.orgstructure.factories.OrgStructureServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteOrgStructureRule implements IProcessRule<DeleteOrgStructureProcess> {

    @Override
    public void apply(DeleteOrgStructureProcess process) {

        var pLogger = LogFactory.builder(DeleteOrgStructureProcess.class, DeleteOrgStructureRule.class);

        var query = process.Query();
        var orgStructure = process.getInitObject();

        query.Field("id", orgStructure.getId());
        query.Where().Equ("id");

        var createOrgStructure = OrgStructureServiceFactory.DeleteOrgStructure(orgStructure.getBusiness().getDbName());
        var result = createOrgStructure.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
