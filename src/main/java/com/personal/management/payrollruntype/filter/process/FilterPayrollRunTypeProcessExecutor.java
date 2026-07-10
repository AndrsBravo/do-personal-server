package com.personal.management.payrollruntype.filter.process;

import com.personal.backoffice.shared.entities.TypeEntity;
import com.personal.management.payrollruntype.filter.process.rules.FilterPayrollRunTypeRule;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollRunTypeProcessExecutor extends FunctionalProcessExecutor<FilterPayrollRunTypeProcess, FilterTypeInput, TypeEntity> {

    public FilterPayrollRunTypeProcessExecutor() {
        super(new FilterPayrollRunTypeProcess(), FilterPayrollRunTypeRule::new);
    }

    public static FilterPayrollRunTypeProcessExecutor builder() {
        return new FilterPayrollRunTypeProcessExecutor();
    }

}
