package com.personal.business.employeededuction.update.process;

import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.employeededuction.update.process.rules.UpdateEmployeeDeductionRule;
import com.personal.business.employeededuction.update.process.rules.UpdateFieldsParamsEmployeeDeductionRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateEmployeeDeductionProcessExecutor extends SupplierProcessExecutor<UpdateEmployeeDeductionProcess, EmployeeDeduction> {

    public UpdateEmployeeDeductionProcessExecutor() {
        super(new UpdateEmployeeDeductionProcess(),
                UpdateFieldsParamsEmployeeDeductionRule::new,
                UpdateEmployeeDeductionRule::new
        );
    }

    public static UpdateEmployeeDeductionProcessExecutor builder() {
        return new UpdateEmployeeDeductionProcessExecutor();
    }

}
