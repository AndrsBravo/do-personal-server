package com.personal.business.payrollemployee.update.process;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.business.payrollemployee.update.process.rules.UpdatePayrollEmployeeRule;
import com.personal.business.payrollemployee.update.process.rules.UpdateFieldsParamsPayrollEmployeeRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollEmployeeProcessExecutor extends SupplierProcessExecutor<UpdatePayrollEmployeeProcess, PayrollEmployee> {

    public UpdatePayrollEmployeeProcessExecutor() {
        super(new UpdatePayrollEmployeeProcess(),
                UpdateFieldsParamsPayrollEmployeeRule::new,
                UpdatePayrollEmployeeRule::new
        );
    }

    public static UpdatePayrollEmployeeProcessExecutor builder() {
        return new UpdatePayrollEmployeeProcessExecutor();
    }

}
