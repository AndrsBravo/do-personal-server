package com.personal.business.hierarchybenefit.update.process.rules;

import com.personal.business.hierarchybenefit.factories.HierarchyBenefitServiceFactory;
import com.personal.business.hierarchybenefit.update.process.UpdateHierarchyBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateHierarchyBenefitRule implements IProcessRule<UpdateHierarchyBenefitProcess> {

    @Override
    public void apply(UpdateHierarchyBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyBenefitProcess.class, UpdateHierarchyBenefitRule.class);
        var hierarchyBenefit = process.getInitObject();
        var createHierarchyBenefit = HierarchyBenefitServiceFactory.EditHierarchyBenefit(hierarchyBenefit.getBusiness().getDbName());
        var result = createHierarchyBenefit.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
