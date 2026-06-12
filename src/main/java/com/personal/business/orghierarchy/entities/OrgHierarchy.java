package com.personal.business.orghierarchy.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedOrgHierarchy;

public class OrgHierarchy extends SharedOrgHierarchy {

    private Business business;

    public OrgHierarchy() {
        super();
    }

    public OrgHierarchy(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
