package com.personal.business.payrollcalculation.create.process;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollCalculationProcess extends SupplierProcess<PayrollCalculation> {

    public CreatePayrollCalculationProcess() {
        super("create_payroll_calculation_process");
    }

}
