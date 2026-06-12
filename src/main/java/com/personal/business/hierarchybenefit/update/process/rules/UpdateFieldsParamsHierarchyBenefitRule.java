package com.personal.business.hierarchybenefit.update.process.rules;

import com.personal.business.hierarchybenefit.update.process.UpdateHierarchyBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsHierarchyBenefitRule implements IProcessRule<UpdateHierarchyBenefitProcess> {

    @Override
    public void apply(UpdateHierarchyBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyBenefitProcess.class, UpdateFieldsParamsHierarchyBenefitRule.class);

        var query = process.Query();

        var hierarchyBenefit = process.getInitObject();

        query.Field("id", hierarchyBenefit.getId());
        query.Where().AndEqu("id");

        if (hierarchyBenefit.getBenefit() != null) {
            query.Set("business_benefits_id", hierarchyBenefit.getBenefit().getId());
        }
        if (hierarchyBenefit.getHierarchy() != null) {
            query.Set("business_hierarchy_id", hierarchyBenefit.getHierarchy().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
