package com.personal.management.benefitdeductionrelation.create.process.rules;

import com.personal.management.benefitdeductionrelation.create.process.CreateBenefitDeductionRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateBenefitDeductionRelationRule implements IProcessRule<CreateBenefitDeductionRelationProcess> {

    @Override
    public void apply(CreateBenefitDeductionRelationProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitDeductionRelationProcess.class, ValidateBenefitDeductionRelationRule.class);
        var query = process.Query();

        var benefitDeductionRelation = process.getInitObject();
        query.Field("id", benefitDeductionRelation.getId());
        query.Field("business_deduction_id", benefitDeductionRelation.getDeduction().getId());
        query.Field("business_benefit_id", benefitDeductionRelation.getBenefit().getId());
        query.Field("created_at", benefitDeductionRelation.getCreatedAt().toString());
        query.Field("updated_at", benefitDeductionRelation.getUpdatedAt().toString());
        query.Field("created_by", benefitDeductionRelation.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
