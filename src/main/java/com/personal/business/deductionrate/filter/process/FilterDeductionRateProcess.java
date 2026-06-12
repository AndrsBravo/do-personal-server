package com.personal.business.deductionrate.filter.process;

import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.business.deductionrate.filter.inputs.FilterDeductionRateInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterDeductionRateProcess extends FunctionalProcess<FilterDeductionRateInput, DeductionRate> {

    public FilterDeductionRateProcess() {
        super("filter_deduction_rate_process");
    }

}
