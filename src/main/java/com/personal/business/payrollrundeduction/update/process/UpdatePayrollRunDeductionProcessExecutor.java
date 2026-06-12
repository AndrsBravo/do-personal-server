package com.personal.business.payrollrundeduction.update.process;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.business.payrollrundeduction.update.process.rules.UpdateFieldsParamsPayrollRunDeductionRule;
import com.personal.business.payrollrundeduction.update.process.rules.UpdatePayrollRunDeductionRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollRunDeductionProcessExecutor extends SupplierProcessExecutor<UpdatePayrollRunDeductionProcess, PayrollRunDeduction> {

    public UpdatePayrollRunDeductionProcessExecutor() {
        super(new UpdatePayrollRunDeductionProcess(),
                UpdateFieldsParamsPayrollRunDeductionRule::new,
                UpdatePayrollRunDeductionRule::new
        );
    }

    public static UpdatePayrollRunDeductionProcessExecutor builder() {
        return new UpdatePayrollRunDeductionProcessExecutor();
    }

}
