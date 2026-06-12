package com.personal.management.payrolldeduction.create.process;

import com.personal.management.payrolldeduction.create.process.rules.CreatePayrollDeductionRule;
import com.personal.management.payrolldeduction.create.process.rules.ValidatePayrollDeductionRule;
import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollDeductionProcessExecutor extends SupplierProcessExecutor<CreatePayrollDeductionProcess, PayrollDeduction> {

    public CreatePayrollDeductionProcessExecutor() {
        super(new CreatePayrollDeductionProcess(),
                ValidatePayrollDeductionRule::new,
                CreatePayrollDeductionRule::new
        );
    }

    public static CreatePayrollDeductionProcessExecutor builder() {
        return new CreatePayrollDeductionProcessExecutor();
    }

}
