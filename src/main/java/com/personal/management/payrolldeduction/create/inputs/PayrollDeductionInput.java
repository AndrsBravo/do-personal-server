package com.personal.management.payrolldeduction.create.inputs;

import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.backoffice.shared.inputs.CountryInputBase;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayroll;

public class PayrollDeductionInput extends CountryInputBase {

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
        payrollDeduction.setCountry(this.getCountry());
        payrollDeduction.setCreatedBy(sessionUser);
        return payrollDeduction;
    }
}
