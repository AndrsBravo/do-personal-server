package com.personal.management.benefit.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedBenefit;

public class Benefit extends SharedBenefit {

    private Country country;

    public Benefit() {
        super();
    }

    public Benefit(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
