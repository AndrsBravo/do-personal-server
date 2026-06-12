package com.personal.management.benefitrate.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedBenefitRate;

public class BenefitRate extends SharedBenefitRate {

    private Country country;

    public BenefitRate() {
        super();
    }

    public BenefitRate(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
