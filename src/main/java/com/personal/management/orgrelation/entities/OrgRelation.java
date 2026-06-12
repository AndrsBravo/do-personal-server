package com.personal.management.orgrelation.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedOrgRelation;

public class OrgRelation extends SharedOrgRelation {

    private Country country;

    public OrgRelation() {
        super();
    }

    public OrgRelation(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
