package com.personal.business.payrollrun.update.process;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.business.payrollrun.update.process.rules.UpdateFieldsParamsPayrollRunRule;
import com.personal.business.payrollrun.update.process.rules.UpdatePayrollRunRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollRunProcessExecutor extends SupplierProcessExecutor<UpdatePayrollRunProcess, PayrollRun> {

    public UpdatePayrollRunProcessExecutor() {
        super(new UpdatePayrollRunProcess(),
                UpdateFieldsParamsPayrollRunRule::new,
                UpdatePayrollRunRule::new
        );
    }

    public static UpdatePayrollRunProcessExecutor builder() {
        return new UpdatePayrollRunProcessExecutor();
    }

}
