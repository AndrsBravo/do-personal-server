package com.personal.business.benefitdeductionrelation.update.process;

import com.personal.business.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.business.benefitdeductionrelation.update.process.rules.UpdateFieldsParamsBenefitDeductionRelationRule;
import com.personal.business.benefitdeductionrelation.update.process.rules.UpdateBenefitDeductionRelationRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateBenefitDeductionRelationProcessExecutor extends SupplierProcessExecutor<UpdateBenefitDeductionRelationProcess, BenefitDeductionRelation> {

    public UpdateBenefitDeductionRelationProcessExecutor() {
        super(new UpdateBenefitDeductionRelationProcess(),
                UpdateFieldsParamsBenefitDeductionRelationRule::new,
                UpdateBenefitDeductionRelationRule::new
        );
    }

    public static UpdateBenefitDeductionRelationProcessExecutor builder() {
        return new UpdateBenefitDeductionRelationProcessExecutor();
    }

}
