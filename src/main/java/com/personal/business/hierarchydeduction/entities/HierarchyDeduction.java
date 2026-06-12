package com.personal.business.hierarchydeduction.entities;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.shared.entities.BusinessEntity;

public class HierarchyDeduction extends BusinessEntity {

    private Deduction deduction;
    private Hierarchy hierarchy;

    public HierarchyDeduction() {
        super();
    }

    public HierarchyDeduction(String id) {
        super(id);
    }

    public Deduction getDeduction() {
        return deduction;
    }

    public void setDeduction(Deduction deduction) {
        this.deduction = deduction;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

}
