package com.personal.business.employee.update.process;

import com.personal.business.employee.entities.Employee;
import com.personal.business.employee.update.process.rules.UpdateFieldsParamsEmployeeRule;
import com.personal.business.employee.update.process.rules.UpdateEmployeeRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateEmployeeProcessExecutor extends SupplierProcessExecutor<UpdateEmployeeProcess, Employee> {

    public UpdateEmployeeProcessExecutor() {
        super(new UpdateEmployeeProcess(),
                UpdateFieldsParamsEmployeeRule::new,
                UpdateEmployeeRule::new
        );
    }

    public static UpdateEmployeeProcessExecutor builder() {
        return new UpdateEmployeeProcessExecutor();
    }

}
