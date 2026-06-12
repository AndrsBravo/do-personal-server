package com.personal.management.benefit.filter.process;

import com.personal.management.benefit.entities.Benefit;
import com.personal.management.benefit.filter.inputs.FilterBenefitInput;
import com.personal.management.benefit.filter.process.rules.FilterBenefitRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBenefitProcessExecutor extends FunctionalProcessExecutor<FilterBenefitProcess, FilterBenefitInput, Benefit> {

    public FilterBenefitProcessExecutor() {
        super(new FilterBenefitProcess(), FilterBenefitRule::new);
    }

    public static FilterBenefitProcessExecutor builder() {
        return new FilterBenefitProcessExecutor();
    }

}
