package com.personal.management.payrollrundeduction.delete.process;

import com.personal.management.payrollrundeduction.delete.process.rules.DeletePayrollRunDeductionRule;
import com.personal.management.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollRunDeductionProcessExecutor extends SupplierProcessExecutor<DeletePayrollRunDeductionProcess, PayrollRunDeduction> {

    public DeletePayrollRunDeductionProcessExecutor() {
        super(new DeletePayrollRunDeductionProcess(),
                DeletePayrollRunDeductionRule::new
        );
    }

    public static DeletePayrollRunDeductionProcessExecutor builder() {
        return new DeletePayrollRunDeductionProcessExecutor();
    }

}
