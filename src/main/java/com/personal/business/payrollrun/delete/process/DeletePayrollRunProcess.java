package com.personal.business.payrollrun.delete.process;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollRunProcess extends SupplierProcess<PayrollRun> {

    public DeletePayrollRunProcess() {
        super("delete_payroll_run_process");
    }

}
