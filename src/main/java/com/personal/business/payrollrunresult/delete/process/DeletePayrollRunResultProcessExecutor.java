package com.personal.business.payrollrunresult.delete.process;

import com.personal.business.payrollrunresult.delete.process.rules.DeletePayrollRunResultRule;
import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollRunResultProcessExecutor extends SupplierProcessExecutor<DeletePayrollRunResultProcess, PayrollRunResult> {

    public DeletePayrollRunResultProcessExecutor() {
        super(new DeletePayrollRunResultProcess(),
                DeletePayrollRunResultRule::new
        );
    }

    public static DeletePayrollRunResultProcessExecutor builder() {
        return new DeletePayrollRunResultProcessExecutor();
    }

}
