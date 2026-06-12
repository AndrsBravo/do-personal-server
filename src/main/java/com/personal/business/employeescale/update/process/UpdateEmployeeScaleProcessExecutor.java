package com.personal.business.employeescale.update.process;

import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.business.employeescale.update.process.rules.UpdateEmployeeScaleRule;
import com.personal.business.employeescale.update.process.rules.UpdateFieldsParamsEmployeeScaleRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateEmployeeScaleProcessExecutor extends SupplierProcessExecutor<UpdateEmployeeScaleProcess, EmployeeScale> {

    public UpdateEmployeeScaleProcessExecutor() {
        super(new UpdateEmployeeScaleProcess(),
                UpdateFieldsParamsEmployeeScaleRule::new,
                UpdateEmployeeScaleRule::new
        );
    }

    public static UpdateEmployeeScaleProcessExecutor builder() {
        return new UpdateEmployeeScaleProcessExecutor();
    }

}
