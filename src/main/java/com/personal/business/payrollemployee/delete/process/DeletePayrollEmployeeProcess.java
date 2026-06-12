package com.personal.business.payrollemployee.delete.process;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollEmployeeProcess extends SupplierProcess<PayrollEmployee> {

    public DeletePayrollEmployeeProcess() {
        super("delete_payroll_employee_process");
    }

}
