package com.personal.management.payrollrundeduction.create.inputs;

import com.personal.management.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.management.shared.inputs.CountryInputBase;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayrollRun;

public class PayrollRunDeductionInput extends CountryInputBase {

    private String deductionId;
    private String payrollRunId;

    public PayrollRunDeductionInput() {
        super();
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public void setPayrollRunId(String payrollRunId) {
        this.payrollRunId = payrollRunId;
    }

    public PayrollRunDeduction getPayrollRunRunDeduction() {
        var payrollRunDeduction = this.id == null || this.id.isEmpty() ? new PayrollRunDeduction() : new PayrollRunDeduction(this.id);
        payrollRunDeduction.setDeduction(new SharedDeduction(deductionId));
        payrollRunDeduction.setPayrollRun(new SharedPayrollRun(payrollRunId));
        payrollRunDeduction.setCountry(this.getCountry());
        payrollRunDeduction.setCreatedBy(sessionUser);
        return payrollRunDeduction;
    }
}
