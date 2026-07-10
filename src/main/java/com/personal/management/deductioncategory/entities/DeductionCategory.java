package com.personal.management.deductioncategory.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedDeductionCategory;

public class DeductionCategory extends SharedDeductionCategory {

    private SharedCountry country;

    public DeductionCategory() {
        super();
    }

    public DeductionCategory(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
