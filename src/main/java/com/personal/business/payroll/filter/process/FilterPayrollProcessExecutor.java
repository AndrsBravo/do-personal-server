package com.personal.business.payroll.filter.process;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payroll.filter.inputs.FilterPayrollInput;
import com.personal.business.payroll.filter.process.rules.FilterPayrollRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollProcessExecutor extends FunctionalProcessExecutor<FilterPayrollProcess, FilterPayrollInput, Payroll> {

    public FilterPayrollProcessExecutor() {
        super(new FilterPayrollProcess(), FilterPayrollRule::new);
    }

    public static FilterPayrollProcessExecutor builder() {
        return new FilterPayrollProcessExecutor();
    }

}
