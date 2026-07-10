package com.personal.management.payrollrundeduction.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedPayrollRunDeduction;

public class PayrollRunDeduction extends SharedPayrollRunDeduction {

    private SharedCountry country;

    public PayrollRunDeduction() {
        super();
    }

    public PayrollRunDeduction(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
