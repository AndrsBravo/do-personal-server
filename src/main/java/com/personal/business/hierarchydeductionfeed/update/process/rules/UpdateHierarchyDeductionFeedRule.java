package com.personal.business.hierarchydeductionfeed.update.process.rules;

import com.personal.business.hierarchydeductionfeed.factories.HierarchyDeductionFeedServiceFactory;
import com.personal.business.hierarchydeductionfeed.update.process.UpdateHierarchyDeductionFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateHierarchyDeductionFeedRule implements IProcessRule<UpdateHierarchyDeductionFeedProcess> {

    @Override
    public void apply(UpdateHierarchyDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyDeductionFeedProcess.class, UpdateHierarchyDeductionFeedRule.class);
        var hierarchyDeductionFeed = process.getInitObject();
        var createHierarchyDeductionFeed = HierarchyDeductionFeedServiceFactory.EditHierarchyDeductionFeed(hierarchyDeductionFeed.getBusiness().getDbName());
        var result = createHierarchyDeductionFeed.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
