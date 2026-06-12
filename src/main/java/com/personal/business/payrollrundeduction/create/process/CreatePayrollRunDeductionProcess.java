package com.personal.business.payrollrundeduction.create.process;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollRunDeductionProcess extends SupplierProcess<PayrollRunDeduction> {

    public CreatePayrollRunDeductionProcess() {
        super("create_payroll_run_deduction_process");
    }

}
