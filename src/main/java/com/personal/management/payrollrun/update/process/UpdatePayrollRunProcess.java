package com.personal.management.payrollrun.update.process;

import com.personal.management.payrollrun.entities.PayrollRun;
import com.personal.shared.process.SupplierProcess;

public class UpdatePayrollRunProcess extends SupplierProcess<PayrollRun> {

    public UpdatePayrollRunProcess() {
        super("update_payroll_run_process");
    }

}
