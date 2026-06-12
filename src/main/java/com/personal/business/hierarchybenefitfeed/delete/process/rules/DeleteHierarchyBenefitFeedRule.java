package com.personal.business.hierarchybenefitfeed.delete.process.rules;

import com.personal.business.hierarchybenefitfeed.delete.process.DeleteHierarchyBenefitFeedProcess;
import com.personal.business.hierarchybenefitfeed.factories.HierarchyBenefitFeedServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteHierarchyBenefitFeedRule implements IProcessRule<DeleteHierarchyBenefitFeedProcess> {

    @Override
    public void apply(DeleteHierarchyBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(DeleteHierarchyBenefitFeedProcess.class, DeleteHierarchyBenefitFeedRule.class);

        var query = process.Query();
        var hierarchyBenefitFeed = process.getInitObject();

        query.Field("id", hierarchyBenefitFeed.getId());
        query.Where().Equ("id");

        var createHierarchyBenefitFeed = HierarchyBenefitFeedServiceFactory.DeleteHierarchyBenefitFeed(hierarchyBenefitFeed.getBusiness().getDbName());
        var result = createHierarchyBenefitFeed.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
