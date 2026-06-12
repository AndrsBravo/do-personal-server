package com.personal.management.payrollbenefit.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedPayrollBenefit;

public class PayrollBenefit extends SharedPayrollBenefit {

    private Country country;

    public PayrollBenefit() {
        super();
    }

    public PayrollBenefit(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
