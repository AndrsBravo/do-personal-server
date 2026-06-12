package com.personal.business.payrollrun.delete.process;

import com.personal.business.payrollrun.delete.process.rules.DeletePayrollRunRule;
import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollRunProcessExecutor extends SupplierProcessExecutor<DeletePayrollRunProcess, PayrollRun> {

    public DeletePayrollRunProcessExecutor() {
        super(new DeletePayrollRunProcess(),
                DeletePayrollRunRule::new
        );
    }

    public static DeletePayrollRunProcessExecutor builder() {
        return new DeletePayrollRunProcessExecutor();
    }

}
