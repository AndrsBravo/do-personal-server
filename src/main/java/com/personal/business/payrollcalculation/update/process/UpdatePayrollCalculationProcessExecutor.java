package com.personal.business.payrollcalculation.update.process;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.business.payrollcalculation.update.process.rules.UpdateFieldsParamsPayrollCalculationRule;
import com.personal.business.payrollcalculation.update.process.rules.UpdatePayrollCalculationRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollCalculationProcessExecutor extends SupplierProcessExecutor<UpdatePayrollCalculationProcess, PayrollCalculation> {

    public UpdatePayrollCalculationProcessExecutor() {
        super(new UpdatePayrollCalculationProcess(),
                UpdateFieldsParamsPayrollCalculationRule::new,
                UpdatePayrollCalculationRule::new
        );
    }

    public static UpdatePayrollCalculationProcessExecutor builder() {
        return new UpdatePayrollCalculationProcessExecutor();
    }

}
