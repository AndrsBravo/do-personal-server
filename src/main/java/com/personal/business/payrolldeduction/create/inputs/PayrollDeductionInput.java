package com.personal.business.payrolldeduction.create.inputs;

import com.personal.business.payrolldeduction.entities.PayrollDeduction;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayroll;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollDeductionInput extends BusinessInputBase {

    private String deductionId;
    private String payrollId;

    public PayrollDeductionInput() {
        super();
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    public PayrollDeduction getPayrollDeduction() {
        var payrollDeduction = this.id == null || this.id.isEmpty() ? new PayrollDeduction() : new PayrollDeduction(this.id);
        payrollDeduction.setDeduction(new SharedDeduction(deductionId));
        payrollDeduction.setPayroll(new SharedPayroll(payrollId));
        payrollDeduction.setBusiness(this.getBusiness());
        payrollDeduction.setCreatedBy(sessionUser);
        return payrollDeduction;
    }
}
