package com.personal.management.payrollrun.create.process;

import com.personal.management.payrollrun.entities.PayrollRun;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollRunProcess extends SupplierProcess<PayrollRun> {

    public CreatePayrollRunProcess() {
        super("create_payroll_run_process");
    }

}
