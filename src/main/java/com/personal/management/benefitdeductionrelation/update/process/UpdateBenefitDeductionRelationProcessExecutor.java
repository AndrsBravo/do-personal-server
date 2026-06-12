package com.personal.management.benefitdeductionrelation.update.process;

import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.management.benefitdeductionrelation.update.process.rules.UpdateFieldsParamsBenefitDeductionRelationRule;
import com.personal.management.benefitdeductionrelation.update.process.rules.UpdateBenefitDeductionRelationRule;
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
