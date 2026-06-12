package com.personal.business.payrollbenefit.create.process;

import com.personal.business.payrollbenefit.create.process.rules.CreatePayrollBenefitRule;
import com.personal.business.payrollbenefit.create.process.rules.ValidatePayrollBenefitRule;
import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollBenefitProcessExecutor extends SupplierProcessExecutor<CreatePayrollBenefitProcess, PayrollBenefit> {

    public CreatePayrollBenefitProcessExecutor() {
        super(new CreatePayrollBenefitProcess(),
                ValidatePayrollBenefitRule::new,
                CreatePayrollBenefitRule::new
        );
    }

    public static CreatePayrollBenefitProcessExecutor builder() {
        return new CreatePayrollBenefitProcessExecutor();
    }

}
