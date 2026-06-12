package com.personal.management.benefitcategory.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedBenefitCategory;

public class BenefitCategory extends SharedBenefitCategory {

    private Country country;

    public BenefitCategory() {
        super();
    }

    public BenefitCategory(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
