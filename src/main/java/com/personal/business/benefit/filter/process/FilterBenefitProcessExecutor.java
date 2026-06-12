package com.personal.business.benefit.filter.process;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.benefit.filter.inputs.FilterBenefitInput;
import com.personal.business.benefit.filter.process.rules.FilterBenefitRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBenefitProcessExecutor extends FunctionalProcessExecutor<FilterBenefitProcess, FilterBenefitInput, Benefit> {

    public FilterBenefitProcessExecutor() {
        super(new FilterBenefitProcess(), FilterBenefitRule::new);
    }

    public static FilterBenefitProcessExecutor builder() {
        return new FilterBenefitProcessExecutor();
    }

}
