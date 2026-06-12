package com.personal.business.hierarchybenefit.create.process.rules;

import com.personal.business.hierarchybenefit.create.process.CreateHierarchyBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateHierarchyBenefitRule implements IProcessRule<CreateHierarchyBenefitProcess> {

    @Override
    public void apply(CreateHierarchyBenefitProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyBenefitProcess.class, ValidateHierarchyBenefitRule.class);
        var query = process.Query();

        var hierarchyBenefit = process.getInitObject();
        query.Field("id", hierarchyBenefit.getId());
        query.Field("business_id", hierarchyBenefit.getBusiness().getId());
        query.Field("business_hierarchy_id", hierarchyBenefit.getHierarchy().getId());
        query.Field("business_benefits_id", hierarchyBenefit.getBenefit().getId());
        query.Field("created_at", hierarchyBenefit.getCreatedAt().toString());
        query.Field("updated_at", hierarchyBenefit.getUpdatedAt().toString());
        query.Field("created_by", hierarchyBenefit.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
