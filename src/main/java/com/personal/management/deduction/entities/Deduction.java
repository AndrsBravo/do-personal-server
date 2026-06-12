package com.personal.management.deduction.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedDeduction;

public class Deduction extends SharedDeduction {

    private Country country;

    public Deduction() {
        super();
    }

    public Deduction(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
