package com.personal.management.deductionrate.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedDeductionRate;

public class DeductionRate extends SharedDeductionRate {

    private Country country;

    public DeductionRate() {
        super();
    }

    public DeductionRate(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
