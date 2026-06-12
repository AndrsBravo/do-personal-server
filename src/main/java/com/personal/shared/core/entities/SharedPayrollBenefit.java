package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedPayrollBenefit extends ShortEntity {

    private SharedBenefit benefit;
    private SharedPayroll payroll;

    public SharedPayrollBenefit() {
        super();
    }

    public SharedPayrollBenefit(String id) {
        super(id);
    }

    public SharedBenefit getBenefit() {
        return benefit;
    }

    public void setBenefit(SharedBenefit benefit) {
        this.benefit = benefit;
    }

    public SharedPayroll getPayroll() {
        return payroll;
    }

    public void setPayroll(SharedPayroll payroll) {
        this.payroll = payroll;
    }

}
