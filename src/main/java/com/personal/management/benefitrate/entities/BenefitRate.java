package com.personal.management.benefitrate.entities;

import com.personal.shared.core.entities.SharedBenefitRate;
import com.personal.shared.core.entities.SharedCountry;

public class BenefitRate extends SharedBenefitRate {

    private SharedCountry country;

    public BenefitRate() {
        super();
    }

    public BenefitRate(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
