package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedPayrollRunBenefit extends ShortEntity {

    private SharedBenefit benefit;
    private SharedPayrollRun payrollRun;

    public SharedPayrollRunBenefit() {
        super();
    }

    public SharedPayrollRunBenefit(String id) {
        super(id);
    }

    public SharedBenefit getBenefit() {
        return benefit;
    }

    public void setBenefit(SharedBenefit benefit) {
        this.benefit = benefit;
    }

    public SharedPayrollRun getPayrollRun() {
        return payrollRun;
    }

    public void setPayrollRun(SharedPayrollRun payrollRun) {
        this.payrollRun = payrollRun;
    }

}
