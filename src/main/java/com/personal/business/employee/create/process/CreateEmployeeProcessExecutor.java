package com.personal.business.employee.create.process;

import com.personal.business.employee.create.process.rules.CreateEmployeeRule;
import com.personal.business.employee.create.process.rules.ValidateEmployeeRule;
import com.personal.business.employee.entities.Employee;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateEmployeeProcessExecutor extends SupplierProcessExecutor<CreateEmployeeProcess, Employee> {

    public CreateEmployeeProcessExecutor() {
        super(new CreateEmployeeProcess(),
                ValidateEmployeeRule::new,
                CreateEmployeeRule::new
        );
    }

    public static CreateEmployeeProcessExecutor builder() {
        return new CreateEmployeeProcessExecutor();
    }

}
