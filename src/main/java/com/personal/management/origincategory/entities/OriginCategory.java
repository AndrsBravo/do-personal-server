package com.personal.management.origincategory.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedOriginCategory;

public class OriginCategory extends SharedOriginCategory {

    private SharedCountry country;

    public OriginCategory() {
        super();
    }

    public OriginCategory(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
