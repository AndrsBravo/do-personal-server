package com.personal.management.payroll.filter.process;

import com.personal.management.payroll.entities.Payroll;
import com.personal.management.payroll.filter.inputs.FilterPayrollInput;
import com.personal.management.payroll.filter.process.rules.FilterPayrollRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollProcessExecutor extends FunctionalProcessExecutor<FilterPayrollProcess, FilterPayrollInput, Payroll> {

    public FilterPayrollProcessExecutor() {
        super(new FilterPayrollProcess(), FilterPayrollRule::new);
    }

    public static FilterPayrollProcessExecutor builder() {
        return new FilterPayrollProcessExecutor();
    }

}
