package com.personal.management.deductioncategory.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedDeductionCategory;

public class DeductionCategory extends SharedDeductionCategory {

    private Country country;

    public DeductionCategory() {
        super();
    }

    public DeductionCategory(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
