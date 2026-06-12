package com.personal.business.hierarchydeduction.create.inputs;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.shared.inputs.BusinessInputBase;

public class HierarchyDeductionInput extends BusinessInputBase {

    private String deductionId;
    private String hierarchyId;

    public HierarchyDeductionInput() {
        super();
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public HierarchyDeduction getHierarchyDeduction() {
        var hierarchyDeduction = this.id == null || this.id.isEmpty() ? new HierarchyDeduction() : new HierarchyDeduction(this.id);
        hierarchyDeduction.setDeduction(new Deduction(deductionId));
        hierarchyDeduction.setHierarchy(new Hierarchy(hierarchyId));
        hierarchyDeduction.setBusiness(this.getBusiness());
        hierarchyDeduction.setCreatedBy(sessionUser);
        return hierarchyDeduction;
    }
}
