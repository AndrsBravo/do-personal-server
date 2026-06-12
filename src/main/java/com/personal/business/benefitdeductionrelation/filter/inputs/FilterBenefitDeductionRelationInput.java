package com.personal.business.benefitdeductionrelation.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterBenefitDeductionRelationInput extends BusinessFilterInputBase {

    private String benefitId;
    private String deductionId;

    public FilterBenefitDeductionRelationInput() {
        super();
    }

    public String getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

}
