package com.personal.management.payrollrun.create.process;

import com.personal.management.payrollrun.create.process.rules.CreatePayrollRunRule;
import com.personal.management.payrollrun.create.process.rules.ValidatePayrollRunRule;
import com.personal.management.payrollrun.entities.PayrollRun;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollRunProcessExecutor extends SupplierProcessExecutor<CreatePayrollRunProcess, PayrollRun> {

    public CreatePayrollRunProcessExecutor() {
        super(new CreatePayrollRunProcess(),
                ValidatePayrollRunRule::new,
                CreatePayrollRunRule::new
        );
    }

    public static CreatePayrollRunProcessExecutor builder() {
        return new CreatePayrollRunProcessExecutor();
    }

}
