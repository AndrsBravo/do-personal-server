package com.personal.business.hierarchydeduction.create.process.rules;

import com.personal.business.hierarchydeduction.create.process.CreateHierarchyDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateHierarchyDeductionRule implements IProcessRule<CreateHierarchyDeductionProcess> {

    @Override
    public void apply(CreateHierarchyDeductionProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyDeductionProcess.class, ValidateHierarchyDeductionRule.class);
        var query = process.Query();

        var hierarchyDeduction = process.getInitObject();
        query.Field("id", hierarchyDeduction.getId());
        query.Field("business_id", hierarchyDeduction.getBusiness().getId());
        query.Field("business_hierarchy_id", hierarchyDeduction.getHierarchy().getId());
        query.Field("business_deductions_id", hierarchyDeduction.getDeduction().getId());
        query.Field("created_at", hierarchyDeduction.getCreatedAt().toString());
        query.Field("updated_at", hierarchyDeduction.getUpdatedAt().toString());
        query.Field("created_by", hierarchyDeduction.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
