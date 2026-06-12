package com.personal.business.payrolldeduction.create.process;

import com.personal.business.payrolldeduction.entities.PayrollDeduction;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollDeductionProcess extends SupplierProcess<PayrollDeduction> {

    public CreatePayrollDeductionProcess() {
        super("create_payroll_deduction_process");
    }

}
