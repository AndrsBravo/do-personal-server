package com.personal.business.payrollcalculationresult.filter.process;

import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.business.payrollcalculationresult.filter.inputs.FilterPayrollCalculationResultInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterPayrollCalculationResultProcess extends FunctionalProcess<FilterPayrollCalculationResultInput, PayrollCalculationResult> {

    public FilterPayrollCalculationResultProcess() {
        super("filter_payroll_calculation_result_process");
    }

}
