package com.personal.business.benefitrate.filter.process;

import com.personal.business.benefitrate.entities.BenefitRate;
import com.personal.business.benefitrate.filter.inputs.FilterBenefitRateInput;
import com.personal.business.benefitrate.filter.process.rules.FilterBenefitRateRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBenefitRateProcessExecutor extends FunctionalProcessExecutor<FilterBenefitRateProcess, FilterBenefitRateInput, BenefitRate> {

    public FilterBenefitRateProcessExecutor() {
        super(new FilterBenefitRateProcess(), FilterBenefitRateRule::new);
    }

    public static FilterBenefitRateProcessExecutor builder() {
        return new FilterBenefitRateProcessExecutor();
    }

}
