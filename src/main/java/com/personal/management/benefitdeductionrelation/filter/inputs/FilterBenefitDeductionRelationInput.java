package com.personal.management.benefitdeductionrelation.filter.inputs;

import com.personal.backoffice.shared.inputs.CountryFilterInputBase;

public class FilterBenefitDeductionRelationInput extends CountryFilterInputBase {

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
