package com.personal.management.payrolldeduction.delete.process;

import com.personal.management.payrolldeduction.delete.process.rules.DeletePayrollDeductionRule;
import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollDeductionProcessExecutor extends SupplierProcessExecutor<DeletePayrollDeductionProcess, PayrollDeduction> {

    public DeletePayrollDeductionProcessExecutor() {
        super(new DeletePayrollDeductionProcess(),
                DeletePayrollDeductionRule::new
        );
    }

    public static DeletePayrollDeductionProcessExecutor builder() {
        return new DeletePayrollDeductionProcessExecutor();
    }

}
