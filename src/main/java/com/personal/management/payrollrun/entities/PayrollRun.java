package com.personal.management.payrollrun.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedPayrollRun;

public class PayrollRun extends SharedPayrollRun {

    private SharedCountry country;

    public PayrollRun() {
        super();
    }

    public PayrollRun(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
