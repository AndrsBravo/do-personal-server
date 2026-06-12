package com.personal.management.benefitdeductionrelation.delete.process;

import com.personal.management.benefitdeductionrelation.delete.process.rules.DeleteBenefitDeductionRelationRule;
import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteBenefitDeductionRelationProcessExecutor extends SupplierProcessExecutor<DeleteBenefitDeductionRelationProcess, BenefitDeductionRelation> {

    public DeleteBenefitDeductionRelationProcessExecutor() {
        super(new DeleteBenefitDeductionRelationProcess(),
                DeleteBenefitDeductionRelationRule::new
        );
    }

    public static DeleteBenefitDeductionRelationProcessExecutor builder() {
        return new DeleteBenefitDeductionRelationProcessExecutor();
    }

}
