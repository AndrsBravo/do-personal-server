package com.personal.business.payrollcalculation.delete.process;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollCalculationProcess extends SupplierProcess<PayrollCalculation> {

    public DeletePayrollCalculationProcess() {
        super("delete_payroll_calculation_process");
    }

}
