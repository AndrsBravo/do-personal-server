package com.personal.business.payroll.delete.process;

import com.personal.business.payroll.entities.Payroll;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollProcess extends SupplierProcess<Payroll> {

    public DeletePayrollProcess() {
        super("delete_payroll_process");
    }

}
