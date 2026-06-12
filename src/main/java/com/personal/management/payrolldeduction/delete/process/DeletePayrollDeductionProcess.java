package com.personal.management.payrolldeduction.delete.process;

import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollDeductionProcess extends SupplierProcess<PayrollDeduction> {

    public DeletePayrollDeductionProcess() {
        super("delete_payroll_deduction_process");
    }

}
