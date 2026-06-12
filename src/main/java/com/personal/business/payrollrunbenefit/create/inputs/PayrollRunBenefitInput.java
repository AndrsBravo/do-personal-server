package com.personal.business.payrollrunbenefit.create.inputs;

import com.personal.business.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedPayrollRun;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollRunBenefitInput extends BusinessInputBase {

    private String benefitId;
    private String payrollRunId;

    public PayrollRunBenefitInput() {
        super();
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public void setPayrollRunId(String payrollRunId) {
        this.payrollRunId = payrollRunId;
    }

    public PayrollRunBenefit getPayrollRunBenefit() {
        var payrollRunBenefit = this.id == null || this.id.isEmpty() ? new PayrollRunBenefit() : new PayrollRunBenefit(this.id);
        payrollRunBenefit.setBenefit(new SharedBenefit(benefitId));
        payrollRunBenefit.setPayrollRun(new SharedPayrollRun(payrollRunId));
        payrollRunBenefit.setBusiness(getBusiness());
        payrollRunBenefit.setCreatedBy(sessionUser);
        return payrollRunBenefit;
    }
}
