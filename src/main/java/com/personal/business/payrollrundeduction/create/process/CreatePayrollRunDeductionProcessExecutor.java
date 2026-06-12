package com.personal.business.payrollrundeduction.create.process;

import com.personal.business.payrollrundeduction.create.process.rules.CreatePayrollRunDeductionRule;
import com.personal.business.payrollrundeduction.create.process.rules.ValidatePayrollRunDeductionRule;
import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollRunDeductionProcessExecutor extends SupplierProcessExecutor<CreatePayrollRunDeductionProcess, PayrollRunDeduction> {

    public CreatePayrollRunDeductionProcessExecutor() {
        super(new CreatePayrollRunDeductionProcess(),
                ValidatePayrollRunDeductionRule::new,
                CreatePayrollRunDeductionRule::new
        );
    }

    public static CreatePayrollRunDeductionProcessExecutor builder() {
        return new CreatePayrollRunDeductionProcessExecutor();
    }

}
