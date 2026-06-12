package com.personal.business.employee.create.process;

import com.personal.business.employee.entities.Employee;
import com.personal.shared.process.SupplierProcess;

public class CreateEmployeeProcess extends SupplierProcess<Employee> {

    public CreateEmployeeProcess() {
        super("create_employee_process");
    }

}
