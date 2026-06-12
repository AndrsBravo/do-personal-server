package com.personal.business.payrollcalculation.update.process;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.shared.process.SupplierProcess;

public class UpdatePayrollCalculationProcess extends SupplierProcess<PayrollCalculation> {

    public UpdatePayrollCalculationProcess() {
        super("update_payroll_calculation_process");
    }

}
