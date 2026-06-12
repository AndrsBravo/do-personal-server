package com.personal.business.benefitdeductionrelation.create.inputs;

import com.personal.business.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.inputs.BusinessInputBase;

public class BenefitDeductionRelationInput extends BusinessInputBase {

    private String benefitId;
    private String deductionId;

    public BenefitDeductionRelationInput() {
        super();
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public BenefitDeductionRelation getBenefitDeductionRelation() {
        var benefitDeductionRelation = this.id == null || this.id.isEmpty() ? new BenefitDeductionRelation() : new BenefitDeductionRelation(this.id);
        benefitDeductionRelation.setBenefit(new SharedBenefit(benefitId));
        benefitDeductionRelation.setDeduction(new SharedDeduction(deductionId));
        benefitDeductionRelation.setBusiness(getBusiness());
        benefitDeductionRelation.setCreatedBy(sessionUser);
        return benefitDeductionRelation;
    }
}
