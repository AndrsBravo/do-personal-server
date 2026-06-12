package com.personal.business.payrollcalculationresult.delete.process;

import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollCalculationResultProcess extends SupplierProcess<PayrollCalculationResult> {

    public DeletePayrollCalculationResultProcess() {
        super("delete_payroll_calculation_result_process");
    }

}
