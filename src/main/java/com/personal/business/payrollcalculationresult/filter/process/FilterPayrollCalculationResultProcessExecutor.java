package com.personal.business.payrollcalculationresult.filter.process;

import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.business.payrollcalculationresult.filter.inputs.FilterPayrollCalculationResultInput;
import com.personal.business.payrollcalculationresult.filter.process.rules.FilterPayrollCalculationResultRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollCalculationResultProcessExecutor extends FunctionalProcessExecutor<FilterPayrollCalculationResultProcess, FilterPayrollCalculationResultInput, PayrollCalculationResult> {

    public FilterPayrollCalculationResultProcessExecutor() {
        super(new FilterPayrollCalculationResultProcess(), FilterPayrollCalculationResultRule::new);
    }

    public static FilterPayrollCalculationResultProcessExecutor builder() {
        return new FilterPayrollCalculationResultProcessExecutor();
    }

}
