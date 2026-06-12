package com.personal.business.hierarchybenefitfeed.update.process.rules;

import com.personal.business.hierarchybenefitfeed.factories.HierarchyBenefitFeedServiceFactory;
import com.personal.business.hierarchybenefitfeed.update.process.UpdateHierarchyBenefitFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateHierarchyBenefitFeedRule implements IProcessRule<UpdateHierarchyBenefitFeedProcess> {

    @Override
    public void apply(UpdateHierarchyBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyBenefitFeedProcess.class, UpdateHierarchyBenefitFeedRule.class);
        var hierarchyBenefitFeed = process.getInitObject();
        var createHierarchyBenefitFeed = HierarchyBenefitFeedServiceFactory.EditHierarchyBenefitFeed(hierarchyBenefitFeed.getBusiness().getDbName());
        var result = createHierarchyBenefitFeed.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
