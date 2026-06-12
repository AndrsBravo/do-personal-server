package com.personal.business.hierarchydeduction.delete.process.rules;

import com.personal.business.hierarchydeduction.delete.process.DeleteHierarchyDeductionProcess;
import com.personal.business.hierarchydeduction.factories.HierarchyDeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteHierarchyDeductionRule implements IProcessRule<DeleteHierarchyDeductionProcess> {

    @Override
    public void apply(DeleteHierarchyDeductionProcess process) {

        var pLogger = LogFactory.builder(DeleteHierarchyDeductionProcess.class, DeleteHierarchyDeductionRule.class);

        var query = process.Query();
        var hierarchyDeduction = process.getInitObject();

        query.Field("id", hierarchyDeduction.getId());
        query.Where().Equ("id");

        var createHierarchyDeduction = HierarchyDeductionServiceFactory.DeleteHierarchyDeduction(hierarchyDeduction.getBusiness().getDbName());
        var result = createHierarchyDeduction.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
