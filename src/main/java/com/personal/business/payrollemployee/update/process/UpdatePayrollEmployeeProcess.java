package com.personal.business.payrollemployee.update.process;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.shared.process.SupplierProcess;

public class UpdatePayrollEmployeeProcess extends SupplierProcess<PayrollEmployee> {

    public UpdatePayrollEmployeeProcess() {
        super("update_payroll_employee_process");
    }

}
