package com.personal.management.payrollrunbenefit.create.inputs;

import com.personal.management.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.management.shared.inputs.CountryInputBase;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedPayrollRun;

public class PayrollRunBenefitInput extends CountryInputBase {

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
        payrollRunBenefit.setCountry(this.getCountry());
        payrollRunBenefit.setCreatedBy(sessionUser);
        return payrollRunBenefit;
    }
}
