package com.personal.business.hierarchy.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.shared.core.entities.SharedOrgHierarchy;

public class Hierarchy extends SharedOrgHierarchy {

    private Business business;
    private OrgHierarchy orgHierarchy;
    private Hierarchy parent;

    public Hierarchy() {
        super();
    }

    public Hierarchy(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public OrgHierarchy getOrgHierarchy() {
        return orgHierarchy;
    }

    public void setOrgHierarchy(OrgHierarchy orgHierarchy) {
        this.orgHierarchy = orgHierarchy;
    }

    public Hierarchy getParent() {
        return parent;
    }

    public void setParent(Hierarchy parent) {
        this.parent = parent;
    }

}
