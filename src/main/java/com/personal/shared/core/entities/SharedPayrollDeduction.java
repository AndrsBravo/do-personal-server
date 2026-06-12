package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedPayrollDeduction extends ShortEntity {

    private SharedDeduction deduction;
    private SharedPayroll payroll;

    public SharedPayrollDeduction() {
        super();
    }

    public SharedPayrollDeduction(String id) {
        super(id);
    }

    public SharedDeduction getDeduction() {
        return deduction;
    }

    public void setDeduction(SharedDeduction deduction) {
        this.deduction = deduction;
    }

    public SharedPayroll getPayroll() {
        return payroll;
    }

    public void setPayroll(SharedPayroll payroll) {
        this.payroll = payroll;
    }

}
