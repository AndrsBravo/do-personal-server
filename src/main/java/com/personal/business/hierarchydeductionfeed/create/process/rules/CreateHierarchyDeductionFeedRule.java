package com.personal.business.hierarchydeductionfeed.create.process.rules;

import com.personal.business.hierarchydeductionfeed.create.process.CreateHierarchyDeductionFeedProcess;
import com.personal.business.hierarchydeductionfeed.factories.HierarchyDeductionFeedServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateHierarchyDeductionFeedRule implements IProcessRule<CreateHierarchyDeductionFeedProcess> {

    @Override
    public void apply(CreateHierarchyDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyDeductionFeedProcess.class, CreateHierarchyDeductionFeedRule.class);
        var hierarchyDeductionFeed = process.getInitObject();
        var createHierarchyDeductionFeed = HierarchyDeductionFeedServiceFactory.CreateHierarchyDeductionFeed(hierarchyDeductionFeed.getBusiness().getDbName());
        var result = createHierarchyDeductionFeed.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
