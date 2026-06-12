package com.personal.business.payrollemployee.create.process;

import com.personal.business.payrollemployee.create.process.rules.CreatePayrollEmployeeRule;
import com.personal.business.payrollemployee.create.process.rules.ValidatePayrollEmployeeRule;
import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollEmployeeProcessExecutor extends SupplierProcessExecutor<CreatePayrollEmployeeProcess, PayrollEmployee> {

    public CreatePayrollEmployeeProcessExecutor() {
        super(new CreatePayrollEmployeeProcess(),
                ValidatePayrollEmployeeRule::new,
                CreatePayrollEmployeeRule::new
        );
    }

    public static CreatePayrollEmployeeProcessExecutor builder() {
        return new CreatePayrollEmployeeProcessExecutor();
    }

}
