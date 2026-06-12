package com.personal.business.hierarchydeduction.create.process.rules;

import com.personal.business.hierarchydeduction.create.process.CreateHierarchyDeductionProcess;
import com.personal.business.hierarchydeduction.factories.HierarchyDeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateHierarchyDeductionRule implements IProcessRule<CreateHierarchyDeductionProcess> {

    @Override
    public void apply(CreateHierarchyDeductionProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyDeductionProcess.class, CreateHierarchyDeductionRule.class);
        var hierarchyDeduction = process.getInitObject();
        var createHierarchyDeduction = HierarchyDeductionServiceFactory.CreateHierarchyDeduction(hierarchyDeduction.getBusiness().getDbName());
        var result = createHierarchyDeduction.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
