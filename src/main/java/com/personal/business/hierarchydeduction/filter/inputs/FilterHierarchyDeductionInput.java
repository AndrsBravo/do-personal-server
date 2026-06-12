package com.personal.business.hierarchydeduction.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterHierarchyDeductionInput extends BusinessFilterInputBase {

    private String deductionId;
    private String hierarchyId;

    public FilterHierarchyDeductionInput() {
        super();
    }

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public String getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

}
