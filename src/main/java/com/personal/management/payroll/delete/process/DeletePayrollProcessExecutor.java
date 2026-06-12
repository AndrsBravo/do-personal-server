package com.personal.management.payroll.delete.process;

import com.personal.management.payroll.delete.process.rules.DeletePayrollRule;
import com.personal.management.payroll.entities.Payroll;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollProcessExecutor extends SupplierProcessExecutor<DeletePayrollProcess, Payroll> {

    public DeletePayrollProcessExecutor() {
        super(new DeletePayrollProcess(),
                DeletePayrollRule::new
        );
    }

    public static DeletePayrollProcessExecutor builder() {
        return new DeletePayrollProcessExecutor();
    }

}
