package com.personal.business.employeededuction.create.process;

import com.personal.business.employeededuction.create.process.rules.CreateEmployeeDeductionRule;
import com.personal.business.employeededuction.create.process.rules.ValidateEmployeeDeductionRule;
import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateEmployeeDeductionProcessExecutor extends SupplierProcessExecutor<CreateEmployeeDeductionProcess, EmployeeDeduction> {

    public CreateEmployeeDeductionProcessExecutor() {
        super(new CreateEmployeeDeductionProcess(),
                ValidateEmployeeDeductionRule::new,
                CreateEmployeeDeductionRule::new
        );
    }

    public static CreateEmployeeDeductionProcessExecutor builder() {
        return new CreateEmployeeDeductionProcessExecutor();
    }

}
