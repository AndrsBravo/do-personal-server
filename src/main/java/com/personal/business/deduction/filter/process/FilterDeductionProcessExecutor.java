package com.personal.business.deduction.filter.process;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.deduction.filter.inputs.FilterDeductionInput;
import com.personal.business.deduction.filter.process.rules.FilterDeductionRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterDeductionProcessExecutor extends FunctionalProcessExecutor<FilterDeductionProcess, FilterDeductionInput, Deduction> {

    public FilterDeductionProcessExecutor() {
        super(new FilterDeductionProcess(), FilterDeductionRule::new);
    }

    public static FilterDeductionProcessExecutor builder() {
        return new FilterDeductionProcessExecutor();
    }

}
