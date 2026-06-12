package com.personal.business.payrollemployee.delete.process;

import com.personal.business.payrollemployee.delete.process.rules.DeletePayrollEmployeeRule;
import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollEmployeeProcessExecutor extends SupplierProcessExecutor<DeletePayrollEmployeeProcess, PayrollEmployee> {

    public DeletePayrollEmployeeProcessExecutor() {
        super(new DeletePayrollEmployeeProcess(),
                DeletePayrollEmployeeRule::new
        );
    }

    public static DeletePayrollEmployeeProcessExecutor builder() {
        return new DeletePayrollEmployeeProcessExecutor();
    }

}
