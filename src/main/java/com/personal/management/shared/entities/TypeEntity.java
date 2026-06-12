package com.personal.management.shared.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.entities.TypeEntityBase;

public class TypeEntity extends TypeEntityBase {

    private Country country;

    public TypeEntity() {
        super();
    }

    public TypeEntity(String id) {
        super(id);

    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
