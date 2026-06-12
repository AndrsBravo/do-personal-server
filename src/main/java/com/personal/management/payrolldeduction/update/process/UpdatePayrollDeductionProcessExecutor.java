package com.personal.management.payrolldeduction.update.process;

import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.management.payrolldeduction.update.process.rules.UpdateFieldsParamsPayrollDeductionRule;
import com.personal.management.payrolldeduction.update.process.rules.UpdatePayrollDeductionRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollDeductionProcessExecutor extends SupplierProcessExecutor<UpdatePayrollDeductionProcess, PayrollDeduction> {

    public UpdatePayrollDeductionProcessExecutor() {
        super(new UpdatePayrollDeductionProcess(),
                UpdateFieldsParamsPayrollDeductionRule::new,
                UpdatePayrollDeductionRule::new
        );
    }

    public static UpdatePayrollDeductionProcessExecutor builder() {
        return new UpdatePayrollDeductionProcessExecutor();
    }

}
