package com.personal.business.payroll.update.process;

import com.personal.business.payroll.entities.Payroll;
import com.personal.shared.process.SupplierProcess;

public class UpdatePayrollProcess extends SupplierProcess<Payroll> {

    public UpdatePayrollProcess() {
        super("update_payroll_process");
    }

}
