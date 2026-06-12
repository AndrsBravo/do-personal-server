package com.personal.management.payroll.update.process;

import com.personal.management.payroll.entities.Payroll;
import com.personal.management.payroll.update.process.rules.UpdatePayrollRule;
import com.personal.management.payroll.update.process.rules.UpdateFieldsParamsPayrollRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollProcessExecutor extends SupplierProcessExecutor<UpdatePayrollProcess, Payroll> {

    public UpdatePayrollProcessExecutor() {
        super(new UpdatePayrollProcess(),
                UpdateFieldsParamsPayrollRule::new,
                UpdatePayrollRule::new
        );
    }

    public static UpdatePayrollProcessExecutor builder() {
        return new UpdatePayrollProcessExecutor();
    }

}
