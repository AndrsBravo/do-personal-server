package com.personal.business.employeededuction.delete.process;

import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.shared.process.SupplierProcess;

public class DeleteEmployeeDeductionProcess extends SupplierProcess<EmployeeDeduction> {

    public DeleteEmployeeDeductionProcess() {
        super("delete_employee_deduction_process");
    }

}
