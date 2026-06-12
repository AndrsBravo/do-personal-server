package com.personal.business.employeededuction.create.process;

import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.shared.process.SupplierProcess;

public class CreateEmployeeDeductionProcess extends SupplierProcess<EmployeeDeduction> {

    public CreateEmployeeDeductionProcess() {
        super("create_employee_deduction_process");
    }

}
