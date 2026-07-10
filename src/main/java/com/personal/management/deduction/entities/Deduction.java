package com.personal.management.deduction.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedDeduction;

public class Deduction extends SharedDeduction {

    private SharedCountry country;

    public Deduction() {
        super();
    }

    public Deduction(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
