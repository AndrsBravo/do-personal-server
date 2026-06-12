package com.personal.business.payrollrundeduction.create.inputs;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayrollRun;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollRunDeductionInput extends BusinessInputBase {

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
        payrollRunDeduction.setBusiness(this.getBusiness());
        payrollRunDeduction.setCreatedBy(sessionUser);
        return payrollRunDeduction;
    }
}
