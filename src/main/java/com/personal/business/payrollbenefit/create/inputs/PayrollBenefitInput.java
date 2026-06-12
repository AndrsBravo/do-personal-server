package com.personal.business.payrollbenefit.create.inputs;

import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedPayroll;
import com.personal.shared.inputs.BusinessInputBase;

public class PayrollBenefitInput extends BusinessInputBase {

    private String benefitId;
    private String payrollId;

    public PayrollBenefitInput() {
        super();
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    public PayrollBenefit getPayrollBenefit() {
        var payrollBenefit = this.id == null || this.id.isEmpty() ? new PayrollBenefit() : new PayrollBenefit(this.id);
        payrollBenefit.setBenefit(new SharedBenefit(benefitId));
        payrollBenefit.setPayroll(new SharedPayroll(payrollId));
        payrollBenefit.setBusiness(this.getBusiness());
        payrollBenefit.setCreatedBy(sessionUser);
        return payrollBenefit;
    }
}
