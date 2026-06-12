package com.personal.business.payrollrun.update.process;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.shared.process.SupplierProcess;

public class UpdatePayrollRunProcess extends SupplierProcess<PayrollRun> {

    public UpdatePayrollRunProcess() {
        super("update_payroll_run_process");
    }

}
