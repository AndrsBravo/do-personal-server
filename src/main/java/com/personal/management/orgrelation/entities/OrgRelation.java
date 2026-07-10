package com.personal.management.orgrelation.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedOrgRelation;

public class OrgRelation extends SharedOrgRelation {

    private SharedCountry country;

    public OrgRelation() {
        super();
    }

    public OrgRelation(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
