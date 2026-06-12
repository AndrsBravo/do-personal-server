package com.personal.business.payrollrun.create.process;

import com.personal.business.payrollrun.create.process.rules.CreatePayrollRunRule;
import com.personal.business.payrollrun.create.process.rules.ValidatePayrollRunRule;
import com.personal.business.payrollrun.entities.PayrollRun;
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
