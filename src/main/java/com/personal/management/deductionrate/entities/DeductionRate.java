package com.personal.management.deductionrate.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedDeductionRate;

public class DeductionRate extends SharedDeductionRate {

    private SharedCountry country;

    public DeductionRate() {
        super();
    }

    public DeductionRate(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
