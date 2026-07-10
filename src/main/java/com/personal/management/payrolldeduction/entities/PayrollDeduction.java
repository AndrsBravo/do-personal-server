package com.personal.management.payrolldeduction.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedPayrollDeduction;

public class PayrollDeduction extends SharedPayrollDeduction {

    private SharedCountry country;

    public PayrollDeduction() {
        super();
    }

    public PayrollDeduction(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
