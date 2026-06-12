package com.personal.business.payrollrunbenefit.create.process;

import com.personal.business.payrollrunbenefit.create.process.rules.CreatePayrollRunBenefitRule;
import com.personal.business.payrollrunbenefit.create.process.rules.ValidatePayrollRunBenefitRule;
import com.personal.business.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollRunBenefitProcessExecutor extends SupplierProcessExecutor<CreatePayrollRunBenefitProcess, PayrollRunBenefit> {

    public CreatePayrollRunBenefitProcessExecutor() {
        super(new CreatePayrollRunBenefitProcess(),
                ValidatePayrollRunBenefitRule::new,
                CreatePayrollRunBenefitRule::new
        );
    }

    public static CreatePayrollRunBenefitProcessExecutor builder() {
        return new CreatePayrollRunBenefitProcessExecutor();
    }

}
