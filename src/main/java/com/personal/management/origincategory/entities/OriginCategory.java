package com.personal.management.origincategory.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedOriginCategory;

public class OriginCategory extends SharedOriginCategory {

    private Country country;

    public OriginCategory() {
        super();
    }

    public OriginCategory(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
