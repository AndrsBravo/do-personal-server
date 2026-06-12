package com.personal.business.payrollcalculation.delete.process;

import com.personal.business.payrollcalculation.delete.process.rules.DeletePayrollCalculationRule;
import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollCalculationProcessExecutor extends SupplierProcessExecutor<DeletePayrollCalculationProcess, PayrollCalculation> {

    public DeletePayrollCalculationProcessExecutor() {
        super(new DeletePayrollCalculationProcess(),
                DeletePayrollCalculationRule::new
        );
    }

    public static DeletePayrollCalculationProcessExecutor builder() {
        return new DeletePayrollCalculationProcessExecutor();
    }

}
