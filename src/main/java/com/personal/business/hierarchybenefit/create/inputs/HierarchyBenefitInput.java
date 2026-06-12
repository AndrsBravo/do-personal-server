package com.personal.business.hierarchybenefit.create.inputs;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.shared.inputs.BusinessInputBase;

public class HierarchyBenefitInput extends BusinessInputBase {

    private String benefitId;
    private String hierarchyId;

    public HierarchyBenefitInput() {
        super();
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public HierarchyBenefit getHierarchyBenefit() {
        var hierarchyBenefit = this.id == null || this.id.isEmpty() ? new HierarchyBenefit() : new HierarchyBenefit(this.id);
        hierarchyBenefit.setBenefit(new Benefit(benefitId));
        hierarchyBenefit.setHierarchy(new Hierarchy(hierarchyId));
        hierarchyBenefit.setBusiness(this.getBusiness());
        hierarchyBenefit.setCreatedBy(sessionUser);
        return hierarchyBenefit;
    }
}
