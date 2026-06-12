package com.personal.business.hierarchybenefit.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterHierarchyBenefitInput extends BusinessFilterInputBase {

    private String benefitId;
    private String hierarchyId;

    public FilterHierarchyBenefitInput() {
        super();
    }

    public String getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

}
