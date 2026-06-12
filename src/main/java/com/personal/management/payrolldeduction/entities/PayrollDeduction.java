package com.personal.management.payrolldeduction.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedPayrollDeduction;

public class PayrollDeduction extends SharedPayrollDeduction {

    private Country country;

    public PayrollDeduction() {
        super();
    }

    public PayrollDeduction(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
