package com.personal.business.payrollrunresult.create.process;

import com.personal.business.payrollrunresult.create.process.rules.CreatePayrollRunResultRule;
import com.personal.business.payrollrunresult.create.process.rules.ValidatePayrollRunResultRule;
import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollRunResultProcessExecutor extends SupplierProcessExecutor<CreatePayrollRunResultProcess, PayrollRunResult> {

    public CreatePayrollRunResultProcessExecutor() {
        super(new CreatePayrollRunResultProcess(),
                ValidatePayrollRunResultRule::new,
                CreatePayrollRunResultRule::new
        );
    }

    public static CreatePayrollRunResultProcessExecutor builder() {
        return new CreatePayrollRunResultProcessExecutor();
    }

}
