package com.personal.business.orgrelation.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.business.country.entities.Country;
import com.personal.shared.core.entities.SharedOrgRelation;

public class OrgRelation extends SharedOrgRelation {

    private Business business;

    public OrgRelation() {
        super();
    }

    public OrgRelation(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
