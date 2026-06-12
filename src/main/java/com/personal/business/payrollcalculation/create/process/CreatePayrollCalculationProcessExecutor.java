package com.personal.business.payrollcalculation.create.process;

import com.personal.business.payrollcalculation.create.process.rules.CreatePayrollCalculationRule;
import com.personal.business.payrollcalculation.create.process.rules.ValidatePayrollCalculationRule;
import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollCalculationProcessExecutor extends SupplierProcessExecutor<CreatePayrollCalculationProcess, PayrollCalculation> {

    public CreatePayrollCalculationProcessExecutor() {
        super(new CreatePayrollCalculationProcess(),
                ValidatePayrollCalculationRule::new,
                CreatePayrollCalculationRule::new
        );
    }

    public static CreatePayrollCalculationProcessExecutor builder() {
        return new CreatePayrollCalculationProcessExecutor();
    }

}
