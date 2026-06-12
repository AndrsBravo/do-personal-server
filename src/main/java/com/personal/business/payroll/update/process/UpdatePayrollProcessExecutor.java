package com.personal.business.payroll.update.process;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payroll.update.process.rules.UpdateFieldsParamsPayrollRule;
import com.personal.business.payroll.update.process.rules.UpdatePayrollRule;
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
