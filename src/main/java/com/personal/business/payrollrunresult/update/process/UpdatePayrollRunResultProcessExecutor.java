package com.personal.business.payrollrunresult.update.process;

import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.business.payrollrunresult.update.process.rules.UpdateFieldsParamsPayrollRunResultRule;
import com.personal.business.payrollrunresult.update.process.rules.UpdatePayrollRunResultRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollRunResultProcessExecutor extends SupplierProcessExecutor<UpdatePayrollRunResultProcess, PayrollRunResult> {

    public UpdatePayrollRunResultProcessExecutor() {
        super(new UpdatePayrollRunResultProcess(),
                UpdateFieldsParamsPayrollRunResultRule::new,
                UpdatePayrollRunResultRule::new
        );
    }

    public static UpdatePayrollRunResultProcessExecutor builder() {
        return new UpdatePayrollRunResultProcessExecutor();
    }

}
