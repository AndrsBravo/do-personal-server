package com.personal.business.orghierarchy.delete.process.rules;

import com.personal.business.orghierarchy.delete.process.DeleteOrgHierarchyProcess;
import com.personal.business.orghierarchy.factories.OrgHierarchyServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteOrgHierarchyRule implements IProcessRule<DeleteOrgHierarchyProcess> {

    @Override
    public void apply(DeleteOrgHierarchyProcess process) {

        var pLogger = LogFactory.builder(DeleteOrgHierarchyProcess.class, DeleteOrgHierarchyRule.class);

        var query = process.Query();
        var orgHierarchy = process.getInitObject();

        query.Field("id", orgHierarchy.getId());
        query.Where().Equ("id");

        var createOrgHierarchy = OrgHierarchyServiceFactory.DeleteOrgHierarchy(orgHierarchy.getBusiness().getDbName());
        var result = createOrgHierarchy.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar nueva Jerarquía", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar nueva Jerarquía", "La Jerarquía ha sido eliminada con éxito"));

    }

}
