package com.personal.business.hierarchydeduction.update.process.rules;

import com.personal.business.hierarchydeduction.update.process.UpdateHierarchyDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsHierarchyDeductionRule implements IProcessRule<UpdateHierarchyDeductionProcess> {

    @Override
    public void apply(UpdateHierarchyDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyDeductionProcess.class, UpdateFieldsParamsHierarchyDeductionRule.class);

        var query = process.Query();

        var hierarchyDeduction = process.getInitObject();

        query.Field("id", hierarchyDeduction.getId());
        query.Where().Equ("id");

        if (hierarchyDeduction.getDeduction() != null) {
            query.Set("business_deductions_id", hierarchyDeduction.getDeduction().getId());
        }
        if (hierarchyDeduction.getHierarchy() != null) {
            query.Set("business_hierarchy_id", hierarchyDeduction.getHierarchy().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
