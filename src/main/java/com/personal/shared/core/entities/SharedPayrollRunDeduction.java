package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedPayrollRunDeduction extends ShortEntity {

    private SharedDeduction deduction;
    private SharedPayrollRun payrollRun;

    public SharedPayrollRunDeduction() {
        super();
    }

    public SharedPayrollRunDeduction(String id) {
        super(id);
    }

    public SharedDeduction getDeduction() {
        return deduction;
    }

    public void setDeduction(SharedDeduction deduction) {
        this.deduction = deduction;
    }

    public SharedPayrollRun getPayrollRun() {
        return payrollRun;
    }

    public void setPayrollRun(SharedPayrollRun payrollRun) {
        this.payrollRun = payrollRun;
    }

}
