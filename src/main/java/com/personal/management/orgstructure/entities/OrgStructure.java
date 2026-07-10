package com.personal.management.orgstructure.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedOrgStructure;

public class OrgStructure extends SharedOrgStructure {

    private SharedCountry country;

    public OrgStructure() {
        super();
    }

    public OrgStructure(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
