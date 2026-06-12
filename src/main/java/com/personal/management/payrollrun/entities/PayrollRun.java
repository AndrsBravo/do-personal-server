package com.personal.management.payrollrun.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedPayrollRun;

public class PayrollRun extends SharedPayrollRun {

    private Country country;

    public PayrollRun() {
        super();
    }

    public PayrollRun(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
