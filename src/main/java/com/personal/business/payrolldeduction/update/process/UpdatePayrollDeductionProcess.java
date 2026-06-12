package com.personal.business.payrolldeduction.update.process;

import com.personal.business.payrolldeduction.entities.PayrollDeduction;
import com.personal.shared.process.SupplierProcess;

public class UpdatePayrollDeductionProcess extends SupplierProcess<PayrollDeduction> {

    public UpdatePayrollDeductionProcess() {
        super("update_payroll_deduction_process");
    }

}
