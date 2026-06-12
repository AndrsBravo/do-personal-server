package com.personal.management.payroll.create.process;

import com.personal.management.payroll.create.process.rules.CreatePayrollRule;
import com.personal.management.payroll.create.process.rules.ValidatePayrollRule;
import com.personal.management.payroll.entities.Payroll;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollProcessExecutor extends SupplierProcessExecutor<CreatePayrollProcess, Payroll> {

    public CreatePayrollProcessExecutor() {
        super(new CreatePayrollProcess(),
                ValidatePayrollRule::new,
                CreatePayrollRule::new
        );
    }

    public static CreatePayrollProcessExecutor builder() {
        return new CreatePayrollProcessExecutor();
    }

}
