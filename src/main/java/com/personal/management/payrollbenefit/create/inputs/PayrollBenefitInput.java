package com.personal.management.payrollbenefit.create.inputs;

import com.personal.management.payrollbenefit.entities.PayrollBenefit;
import com.personal.management.shared.inputs.CountryInputBase;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedPayroll;

public class PayrollBenefitInput extends CountryInputBase {

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
        payrollBenefit.setCountry(this.getCountry());
        payrollBenefit.setCreatedBy(sessionUser);
        return payrollBenefit;
    }
}
