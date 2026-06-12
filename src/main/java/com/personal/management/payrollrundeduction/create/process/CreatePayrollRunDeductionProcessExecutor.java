package com.personal.management.payrollrundeduction.create.process;

import com.personal.management.payrollrundeduction.create.process.rules.CreatePayrollRunDeductionRule;
import com.personal.management.payrollrundeduction.create.process.rules.ValidatePayrollRunDeductionRule;
import com.personal.management.payrollrundeduction.entities.PayrollRunDeduction;
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
