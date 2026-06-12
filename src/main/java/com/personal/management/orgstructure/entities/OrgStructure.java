package com.personal.management.orgstructure.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedOrgStructure;

public class OrgStructure extends SharedOrgStructure {

    private Country country;

    public OrgStructure() {
        super();
    }

    public OrgStructure(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
