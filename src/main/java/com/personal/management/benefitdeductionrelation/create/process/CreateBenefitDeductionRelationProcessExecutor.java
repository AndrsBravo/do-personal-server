package com.personal.management.benefitdeductionrelation.create.process;

import com.personal.management.benefitdeductionrelation.create.process.rules.CreateBenefitDeductionRelationRule;
import com.personal.management.benefitdeductionrelation.create.process.rules.ValidateBenefitDeductionRelationRule;
import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateBenefitDeductionRelationProcessExecutor extends SupplierProcessExecutor<CreateBenefitDeductionRelationProcess, BenefitDeductionRelation> {

    public CreateBenefitDeductionRelationProcessExecutor() {
        super(new CreateBenefitDeductionRelationProcess(),
                ValidateBenefitDeductionRelationRule::new,
                CreateBenefitDeductionRelationRule::new
        );
    }

    public static CreateBenefitDeductionRelationProcessExecutor builder() {
        return new CreateBenefitDeductionRelationProcessExecutor();
    }

}
