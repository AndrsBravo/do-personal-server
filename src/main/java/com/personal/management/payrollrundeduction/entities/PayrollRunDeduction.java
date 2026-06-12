package com.personal.management.payrollrundeduction.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedPayrollRunDeduction;

public class PayrollRunDeduction extends SharedPayrollRunDeduction {

    private Country country;

    public PayrollRunDeduction() {
        super();
    }

    public PayrollRunDeduction(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
