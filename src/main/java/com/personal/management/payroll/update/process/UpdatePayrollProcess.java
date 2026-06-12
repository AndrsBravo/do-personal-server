package com.personal.management.payroll.update.process;

import com.personal.management.payroll.entities.Payroll;
import com.personal.shared.process.SupplierProcess;

public class UpdatePayrollProcess extends SupplierProcess<Payroll> {

    public UpdatePayrollProcess() {
        super("update_payroll_process");
    }

}
