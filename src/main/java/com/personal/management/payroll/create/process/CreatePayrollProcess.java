package com.personal.management.payroll.create.process;

import com.personal.management.payroll.entities.Payroll;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollProcess extends SupplierProcess<Payroll> {

    public CreatePayrollProcess() {
        super("create_payroll_process");
    }

}
