package com.personal.business.employee.delete.process;

import com.personal.business.employee.delete.process.rules.DeleteEmployeeRule;
import com.personal.business.employee.entities.Employee;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteEmployeeProcessExecutor extends SupplierProcessExecutor<DeleteEmployeeProcess, Employee> {

    public DeleteEmployeeProcessExecutor() {
        super(new DeleteEmployeeProcess(),
                DeleteEmployeeRule::new
        );
    }

    public static DeleteEmployeeProcessExecutor builder() {
        return new DeleteEmployeeProcessExecutor();
    }

}
