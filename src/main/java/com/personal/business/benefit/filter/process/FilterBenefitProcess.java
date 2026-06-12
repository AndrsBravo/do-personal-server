package com.personal.business.benefit.filter.process;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.benefit.filter.inputs.FilterBenefitInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterBenefitProcess extends FunctionalProcess<FilterBenefitInput, Benefit> {

    public FilterBenefitProcess() {
        super("filter_benefit_");
    }

}
