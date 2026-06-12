package com.personal.business.orgstructure.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedOrgStructure;

public class OrgStructure extends SharedOrgStructure {

    private Business business;

    public OrgStructure() {
        super();
    }

    public OrgStructure(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
