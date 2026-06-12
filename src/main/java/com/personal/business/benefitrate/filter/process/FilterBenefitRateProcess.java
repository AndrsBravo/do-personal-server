package com.personal.business.benefitrate.filter.process;

import com.personal.business.benefitrate.entities.BenefitRate;
import com.personal.business.benefitrate.filter.inputs.FilterBenefitRateInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterBenefitRateProcess extends FunctionalProcess<FilterBenefitRateInput, BenefitRate> {

    public FilterBenefitRateProcess() {
        super("filter_benefit_rate_process");
    }

}
