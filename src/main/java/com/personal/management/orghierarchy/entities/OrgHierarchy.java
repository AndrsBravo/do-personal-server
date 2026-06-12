package com.personal.management.orghierarchy.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedOrgHierarchy;

public class OrgHierarchy extends SharedOrgHierarchy {

    private Country country;

    public OrgHierarchy() {
        super();
    }

    public OrgHierarchy(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
