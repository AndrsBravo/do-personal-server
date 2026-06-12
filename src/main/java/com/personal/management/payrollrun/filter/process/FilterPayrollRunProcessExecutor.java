package com.personal.management.payrollrun.filter.process;

import com.personal.management.payrollrun.entities.PayrollRun;
import com.personal.management.payrollrun.filter.inputs.FilterPayrollRunInput;
import com.personal.management.payrollrun.filter.process.rules.FilterPayrollRunRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollRunProcessExecutor extends FunctionalProcessExecutor<FilterPayrollRunProcess, FilterPayrollRunInput, PayrollRun> {

    public FilterPayrollRunProcessExecutor() {
        super(new FilterPayrollRunProcess(), FilterPayrollRunRule::new);
    }

    public static FilterPayrollRunProcessExecutor builder() {
        return new FilterPayrollRunProcessExecutor();
    }

}
