package com.personal.management.payrollruntype.delete.process;

import com.personal.management.payrollruntype.delete.process.rules.DeletePayrollRunTypeRule;
import com.personal.management.shared.entities.TypeEntity;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollRunTypeProcessExecutor extends SupplierProcessExecutor<DeletePayrollRunTypeProcess, TypeEntity> {

    public DeletePayrollRunTypeProcessExecutor() {
        super(new DeletePayrollRunTypeProcess(),
                DeletePayrollRunTypeRule::new
        );
    }

    public static DeletePayrollRunTypeProcessExecutor builder() {
        return new DeletePayrollRunTypeProcessExecutor();
    }

}
