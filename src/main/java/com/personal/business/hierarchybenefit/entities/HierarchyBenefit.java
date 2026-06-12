package com.personal.business.hierarchybenefit.entities;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.shared.entities.BusinessEntity;

public class HierarchyBenefit extends BusinessEntity {

    private Benefit benefit;
    private Hierarchy hierarchy;

    public HierarchyBenefit() {
        super();
    }

    public HierarchyBenefit(String id) {
        super(id);
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

}
