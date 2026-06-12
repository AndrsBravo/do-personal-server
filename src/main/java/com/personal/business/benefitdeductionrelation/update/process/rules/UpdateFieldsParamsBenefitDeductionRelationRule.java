package com.personal.business.benefitdeductionrelation.update.process.rules;

import com.personal.business.benefitdeductionrelation.update.process.UpdateBenefitDeductionRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsBenefitDeductionRelationRule implements IProcessRule<UpdateBenefitDeductionRelationProcess> {

    @Override
    public void apply(UpdateBenefitDeductionRelationProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitDeductionRelationProcess.class, UpdateFieldsParamsBenefitDeductionRelationRule.class);

        var query = process.Query();

        var benefitDeductionRelation = process.getInitObject();

        query.Field("id", benefitDeductionRelation.getId());
        query.Where().AndEqu("id");

        if (benefitDeductionRelation.getBenefit() != null) {
            query.Set("business_benefit_id", benefitDeductionRelation.getBenefit().getId());
        }
        if (benefitDeductionRelation.getDeduction() != null) {
            query.Set("business_deduction_id", benefitDeductionRelation.getDeduction().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
