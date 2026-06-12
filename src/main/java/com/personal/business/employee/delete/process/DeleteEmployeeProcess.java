package com.personal.business.employee.delete.process;

import com.personal.business.employee.entities.Employee;
import com.personal.shared.process.SupplierProcess;

public class DeleteEmployeeProcess extends SupplierProcess<Employee> {

    public DeleteEmployeeProcess() {
        super("delete_employee_process");
    }

}
