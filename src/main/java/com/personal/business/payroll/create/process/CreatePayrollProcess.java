package com.personal.business.payroll.create.process;

import com.personal.business.payroll.entities.Payroll;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollProcess extends SupplierProcess<Payroll> {

    public CreatePayrollProcess() {
        super("create_payroll_process");
    }

}
