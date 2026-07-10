package com.personal.management.payrollbenefit.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedPayrollBenefit;

public class PayrollBenefit extends SharedPayrollBenefit {

    private SharedCountry country;

    public PayrollBenefit() {
        super();
    }

    public PayrollBenefit(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
