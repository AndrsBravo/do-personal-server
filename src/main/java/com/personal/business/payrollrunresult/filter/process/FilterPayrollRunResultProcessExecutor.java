package com.personal.business.payrollrunresult.filter.process;

import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.business.payrollrunresult.filter.inputs.FilterPayrollRunResultInput;
import com.personal.business.payrollrunresult.filter.process.rules.FilterPayrollRunResultRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollRunResultProcessExecutor extends FunctionalProcessExecutor<FilterPayrollRunResultProcess, FilterPayrollRunResultInput, PayrollRunResult> {

    public FilterPayrollRunResultProcessExecutor() {
        super(new FilterPayrollRunResultProcess(), FilterPayrollRunResultRule::new);
    }

    public static FilterPayrollRunResultProcessExecutor builder() {
        return new FilterPayrollRunResultProcessExecutor();
    }

}
