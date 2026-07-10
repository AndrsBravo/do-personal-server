package com.personal.management.payroll.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedPayroll;

public class Payroll extends SharedPayroll {

    private SharedCountry country;

    public Payroll() {
        super();
    }

    public Payroll(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
