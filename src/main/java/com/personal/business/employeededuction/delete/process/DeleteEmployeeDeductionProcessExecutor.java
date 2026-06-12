package com.personal.business.employeededuction.delete.process;

import com.personal.business.employeededuction.delete.process.rules.DeleteEmployeeDeductionRule;
import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteEmployeeDeductionProcessExecutor extends SupplierProcessExecutor<DeleteEmployeeDeductionProcess, EmployeeDeduction> {

    public DeleteEmployeeDeductionProcessExecutor() {
        super(new DeleteEmployeeDeductionProcess(),
                DeleteEmployeeDeductionRule::new
        );
    }

    public static DeleteEmployeeDeductionProcessExecutor builder() {
        return new DeleteEmployeeDeductionProcessExecutor();
    }

}
