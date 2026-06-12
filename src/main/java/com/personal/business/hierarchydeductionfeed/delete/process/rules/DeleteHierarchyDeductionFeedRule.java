package com.personal.business.hierarchydeductionfeed.delete.process.rules;

import com.personal.business.hierarchydeductionfeed.delete.process.DeleteHierarchyDeductionFeedProcess;
import com.personal.business.hierarchydeductionfeed.factories.HierarchyDeductionFeedServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteHierarchyDeductionFeedRule implements IProcessRule<DeleteHierarchyDeductionFeedProcess> {

    @Override
    public void apply(DeleteHierarchyDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(DeleteHierarchyDeductionFeedProcess.class, DeleteHierarchyDeductionFeedRule.class);

        var query = process.Query();
        var hierarchyDeductionFeed = process.getInitObject();

        query.Field("id", hierarchyDeductionFeed.getId());
        query.Where().Equ("id");

        var createHierarchyDeductionFeed = HierarchyDeductionFeedServiceFactory.DeleteHierarchyDeductionFeed(hierarchyDeductionFeed.getBusiness().getDbName());
        var result = createHierarchyDeductionFeed.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
