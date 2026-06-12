package com.personal.management.benefitrate.filter.process;

import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.management.benefitrate.filter.inputs.FilterBenefitRateInput;
import com.personal.management.benefitrate.filter.process.rules.FilterBenefitRateRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBenefitRateProcessExecutor extends FunctionalProcessExecutor<FilterBenefitRateProcess, FilterBenefitRateInput, BenefitRate> {

    public FilterBenefitRateProcessExecutor() {
        super(new FilterBenefitRateProcess(), FilterBenefitRateRule::new);
    }

    public static FilterBenefitRateProcessExecutor builder() {
        return new FilterBenefitRateProcessExecutor();
    }

}
