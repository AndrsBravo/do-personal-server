package com.personal.business.hierarchydeduction.update.process.rules;

import com.personal.business.hierarchydeduction.factories.HierarchyDeductionServiceFactory;
import com.personal.business.hierarchydeduction.update.process.UpdateHierarchyDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateHierarchyDeductionRule implements IProcessRule<UpdateHierarchyDeductionProcess> {

    @Override
    public void apply(UpdateHierarchyDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyDeductionProcess.class, UpdateHierarchyDeductionRule.class);
        var hierarchyDeduction = process.getInitObject();
        var createHierarchyDeduction = HierarchyDeductionServiceFactory.EditHierarchyDeduction(hierarchyDeduction.getBusiness().getDbName());
        var result = createHierarchyDeduction.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
