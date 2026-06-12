package com.personal.business.payrollrunresult.delete.process;

import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollRunResultProcess extends SupplierProcess<PayrollRunResult> {

    public DeletePayrollRunResultProcess() {
        super("delete_payroll_run_result_process");
    }

}
