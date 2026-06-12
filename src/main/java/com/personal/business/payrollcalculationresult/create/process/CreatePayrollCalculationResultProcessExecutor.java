package com.personal.business.payrollcalculationresult.create.process;

import com.personal.business.payrollcalculationresult.create.process.rules.CreatePayrollCalculationResultRule;
import com.personal.business.payrollcalculationresult.create.process.rules.ValidatePayrollCalculationResultRule;
import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollCalculationResultProcessExecutor extends SupplierProcessExecutor<CreatePayrollCalculationResultProcess, PayrollCalculationResult> {

    public CreatePayrollCalculationResultProcessExecutor() {
        super(new CreatePayrollCalculationResultProcess(),
                ValidatePayrollCalculationResultRule::new,
                CreatePayrollCalculationResultRule::new
        );
    }

    public static CreatePayrollCalculationResultProcessExecutor builder() {
        return new CreatePayrollCalculationResultProcessExecutor();
    }

}
