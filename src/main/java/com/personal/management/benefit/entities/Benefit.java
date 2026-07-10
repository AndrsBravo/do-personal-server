package com.personal.management.benefit.entities;

import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedCountry;

public class Benefit extends SharedBenefit {

    private SharedCountry country;

    public Benefit() {
        super();
    }

    public Benefit(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
