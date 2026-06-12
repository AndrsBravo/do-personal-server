package com.personal.management.benefit.filter.process;

import com.personal.management.benefit.entities.Benefit;
import com.personal.management.benefit.filter.inputs.FilterBenefitInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterBenefitProcess extends FunctionalProcess<FilterBenefitInput, Benefit> {

    public FilterBenefitProcess() {
        super("filter_benefit_");
    }

}
