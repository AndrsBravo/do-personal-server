package com.personal.business.hierarchybenefit.create.process.rules;

import com.personal.business.hierarchybenefit.create.process.CreateHierarchyBenefitProcess;
import com.personal.business.hierarchybenefit.factories.HierarchyBenefitServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateHierarchyBenefitRule implements IProcessRule<CreateHierarchyBenefitProcess> {

    @Override
    public void apply(CreateHierarchyBenefitProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyBenefitProcess.class, CreateHierarchyBenefitRule.class);
        var hierarchyBenefit = process.getInitObject();
        var createHierarchyBenefit = HierarchyBenefitServiceFactory.CreateHierarchyBenefit(hierarchyBenefit.getBusiness().getDbName());
        var result = createHierarchyBenefit.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
