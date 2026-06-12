package com.personal.business.employeescale.create.process;

import com.personal.business.employeescale.create.process.rules.CreateEmployeeScaleRule;
import com.personal.business.employeescale.create.process.rules.ValidateEmployeeScaleRule;
import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateEmployeeScaleProcessExecutor extends SupplierProcessExecutor<CreateEmployeeScaleProcess, EmployeeScale> {

    public CreateEmployeeScaleProcessExecutor() {
        super(new CreateEmployeeScaleProcess(),
                ValidateEmployeeScaleRule::new,
                CreateEmployeeScaleRule::new
        );
    }

    public static CreateEmployeeScaleProcessExecutor builder() {
        return new CreateEmployeeScaleProcessExecutor();
    }

}
