package com.personal.business.payrollrundeduction.delete.process;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollRunDeductionProcess extends SupplierProcess<PayrollRunDeduction> {

    public DeletePayrollRunDeductionProcess() {
        super("delete_payroll_run_deduction_process");
    }

}
