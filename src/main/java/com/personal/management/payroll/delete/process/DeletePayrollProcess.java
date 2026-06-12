package com.personal.management.payroll.delete.process;

import com.personal.management.payroll.entities.Payroll;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollProcess extends SupplierProcess<Payroll> {

    public DeletePayrollProcess() {
        super("delete_payroll_process");
    }

}
