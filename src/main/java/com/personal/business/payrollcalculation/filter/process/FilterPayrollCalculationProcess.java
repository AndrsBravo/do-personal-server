package com.personal.business.payrollcalculation.filter.process;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.business.payrollcalculation.filter.inputs.FilterPayrollCalculationInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollCalculationProcess extends FunctionalProcess<FilterPayrollCalculationInput, PayrollCalculation> {

    public FilterPayrollCalculationProcess() {
        super("filter_payroll_calculation_process");
    }

}
