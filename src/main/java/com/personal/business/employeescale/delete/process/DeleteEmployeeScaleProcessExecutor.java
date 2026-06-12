package com.personal.business.employeescale.delete.process;

import com.personal.business.employeescale.delete.process.rules.DeleteEmployeeScaleRule;
import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteEmployeeScaleProcessExecutor extends SupplierProcessExecutor<DeleteEmployeeScaleProcess, EmployeeScale> {

    public DeleteEmployeeScaleProcessExecutor() {
        super(new DeleteEmployeeScaleProcess(),
                DeleteEmployeeScaleRule::new
        );
    }

    public static DeleteEmployeeScaleProcessExecutor builder() {
        return new DeleteEmployeeScaleProcessExecutor();
    }

}
