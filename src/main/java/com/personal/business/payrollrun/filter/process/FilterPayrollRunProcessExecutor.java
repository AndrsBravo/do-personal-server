package com.personal.business.payrollrun.filter.process;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.business.payrollrun.filter.inputs.FilterPayrollRunInput;
import com.personal.business.payrollrun.filter.process.rules.FilterPayrollRunRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollRunProcessExecutor extends FunctionalProcessExecutor<FilterPayrollRunProcess, FilterPayrollRunInput, PayrollRun> {

    public FilterPayrollRunProcessExecutor() {
        super(new FilterPayrollRunProcess(), FilterPayrollRunRule::new);
    }

    public static FilterPayrollRunProcessExecutor builder() {
        return new FilterPayrollRunProcessExecutor();
    }

}
