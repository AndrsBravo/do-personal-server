package com.personal.management.payrollrundeduction.delete.process;

import com.personal.management.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollRunDeductionProcess extends SupplierProcess<PayrollRunDeduction> {

    public DeletePayrollRunDeductionProcess() {
        super("delete_payroll_run_deduction_process");
    }

}
