package com.personal.business.payrolldeduction.update.process;

import com.personal.business.payrolldeduction.entities.PayrollDeduction;
import com.personal.business.payrolldeduction.update.process.rules.UpdatePayrollDeductionRule;
import com.personal.business.payrolldeduction.update.process.rules.UpdateFieldsParamsPayrollDeductionRule;
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
