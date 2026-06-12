package com.personal.business.hierarchybenefitfeed.create.process.rules;

import com.personal.business.hierarchybenefitfeed.create.process.CreateHierarchyBenefitFeedProcess;
import com.personal.business.hierarchybenefitfeed.factories.HierarchyBenefitFeedServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateHierarchyBenefitFeedRule implements IProcessRule<CreateHierarchyBenefitFeedProcess> {

    @Override
    public void apply(CreateHierarchyBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyBenefitFeedProcess.class, CreateHierarchyBenefitFeedRule.class);
        var hierarchyBenefitFeed = process.getInitObject();
        var createHierarchyBenefitFeed = HierarchyBenefitFeedServiceFactory.CreateHierarchyBenefitFeed(hierarchyBenefitFeed.getBusiness().getDbName());
        var result = createHierarchyBenefitFeed.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
