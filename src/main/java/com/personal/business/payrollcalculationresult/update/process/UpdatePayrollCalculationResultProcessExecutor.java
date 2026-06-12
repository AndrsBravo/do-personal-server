package com.personal.business.payrollcalculationresult.update.process;

import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.business.payrollcalculationresult.update.process.rules.UpdateFieldsParamsPayrollCalculationResultRule;
import com.personal.business.payrollcalculationresult.update.process.rules.UpdatePayrollCalculationResultRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollCalculationResultProcessExecutor extends SupplierProcessExecutor<UpdatePayrollCalculationResultProcess, PayrollCalculationResult> {

    public UpdatePayrollCalculationResultProcessExecutor() {
        super(new UpdatePayrollCalculationResultProcess(),
                UpdateFieldsParamsPayrollCalculationResultRule::new,
                UpdatePayrollCalculationResultRule::new
        );
    }

    public static UpdatePayrollCalculationResultProcessExecutor builder() {
        return new UpdatePayrollCalculationResultProcessExecutor();
    }

}
