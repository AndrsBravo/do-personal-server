package com.personal.business.payrollcalculationresult.delete.process;

import com.personal.business.payrollcalculationresult.delete.process.rules.DeletePayrollCalculationResultRule;
import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollCalculationResultProcessExecutor extends SupplierProcessExecutor<DeletePayrollCalculationResultProcess, PayrollCalculationResult> {

    public DeletePayrollCalculationResultProcessExecutor() {
        super(new DeletePayrollCalculationResultProcess(),
                DeletePayrollCalculationResultRule::new
        );
    }

    public static DeletePayrollCalculationResultProcessExecutor builder() {
        return new DeletePayrollCalculationResultProcessExecutor();
    }

}
