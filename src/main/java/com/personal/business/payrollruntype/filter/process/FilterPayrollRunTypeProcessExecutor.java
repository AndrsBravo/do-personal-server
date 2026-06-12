package com.personal.business.payrollruntype.filter.process;

import com.personal.business.payrollruntype.filter.process.rules.FilterPayrollRunTypeRule;
import com.personal.business.shared.entities.TypeEntity;
import com.personal.business.shared.inputs.BusinessFilterTypeInput;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterPayrollRunTypeProcessExecutor extends FunctionalProcessExecutor<FilterPayrollRunTypeProcess, BusinessFilterTypeInput, TypeEntity> {

    public FilterPayrollRunTypeProcessExecutor() {
        super(new FilterPayrollRunTypeProcess(), FilterPayrollRunTypeRule::new);
    }

    public static FilterPayrollRunTypeProcessExecutor builder() {
        return new FilterPayrollRunTypeProcessExecutor();
    }

}
