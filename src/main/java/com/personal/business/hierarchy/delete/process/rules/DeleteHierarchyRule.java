package com.personal.business.hierarchy.delete.process.rules;

import com.personal.business.hierarchy.delete.process.DeleteHierarchyProcess;
import com.personal.business.hierarchy.factories.HierarchyServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteHierarchyRule implements IProcessRule<DeleteHierarchyProcess> {

    @Override
    public void apply(DeleteHierarchyProcess process) {

        var pLogger = LogFactory.builder(DeleteHierarchyProcess.class, DeleteHierarchyRule.class);

        var query = process.Query();
        var hierarchy = process.getInitObject();

        query.Field("id", hierarchy.getId());
        query.Where().Equ("id");

        var createHierarchy = HierarchyServiceFactory.DeleteHierarchy(hierarchy.getBusiness().getDbName());
        var result = createHierarchy.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
