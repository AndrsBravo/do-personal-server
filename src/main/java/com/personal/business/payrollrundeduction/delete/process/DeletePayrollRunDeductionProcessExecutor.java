package com.personal.business.payrollrundeduction.delete.process;

import com.personal.business.payrollrundeduction.delete.process.rules.DeletePayrollRunDeductionRule;
import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
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
