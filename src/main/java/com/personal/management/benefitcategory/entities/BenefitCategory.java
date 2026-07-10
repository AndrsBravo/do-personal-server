package com.personal.management.benefitcategory.entities;

import com.personal.shared.core.entities.SharedBenefitCategory;
import com.personal.shared.core.entities.SharedCountry;

public class BenefitCategory extends SharedBenefitCategory {

    private SharedCountry country;

    public BenefitCategory() {
        super();
    }

    public BenefitCategory(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
