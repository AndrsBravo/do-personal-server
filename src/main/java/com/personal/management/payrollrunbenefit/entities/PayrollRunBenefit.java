package com.personal.management.payrollrunbenefit.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedPayrollRunBenefit;

public class PayrollRunBenefit extends SharedPayrollRunBenefit {

    private SharedCountry country;

    public PayrollRunBenefit() {
        super();
    }

    public PayrollRunBenefit(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
