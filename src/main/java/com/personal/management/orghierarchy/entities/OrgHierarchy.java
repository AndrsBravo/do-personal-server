package com.personal.management.orghierarchy.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedOrgHierarchy;

public class OrgHierarchy extends SharedOrgHierarchy {

    private SharedCountry country;

    public OrgHierarchy() {
        super();
    }

    public OrgHierarchy(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
