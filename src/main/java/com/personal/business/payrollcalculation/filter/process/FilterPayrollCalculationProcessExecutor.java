package com.personal.business.payrollcalculation.filter.process;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.business.payrollcalculation.filter.inputs.FilterPayrollCalculationInput;
import com.personal.business.payrollcalculation.filter.process.rules.FilterPayrollCalculationRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollCalculationProcessExecutor extends FunctionalProcessExecutor<FilterPayrollCalculationProcess, FilterPayrollCalculationInput, PayrollCalculation> {

    public FilterPayrollCalculationProcessExecutor() {
        super(new FilterPayrollCalculationProcess(), FilterPayrollCalculationRule::new);
    }

    public static FilterPayrollCalculationProcessExecutor builder() {
        return new FilterPayrollCalculationProcessExecutor();
    }

}
