package com.personal.management.payrollrunbenefit.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedPayrollRunBenefit;

public class PayrollRunBenefit extends SharedPayrollRunBenefit {

    private Country country;

    public PayrollRunBenefit() {
        super();
    }

    public PayrollRunBenefit(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
