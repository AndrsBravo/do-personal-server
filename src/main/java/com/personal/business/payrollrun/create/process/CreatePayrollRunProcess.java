package com.personal.business.payrollrun.create.process;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollRunProcess extends SupplierProcess<PayrollRun> {

    public CreatePayrollRunProcess() {
        super("create_payroll_run_process");
    }

}
