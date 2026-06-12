package com.personal.business.payrollemployee.create.process;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollEmployeeProcess extends SupplierProcess<PayrollEmployee> {

    public CreatePayrollEmployeeProcess() {
        super("create_payroll_employee_process");
    }

}
