package com.personal.management.payroll.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedPayroll;

public class Payroll extends SharedPayroll {

    private Country country;

    public Payroll() {
        super();
    }

    public Payroll(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
