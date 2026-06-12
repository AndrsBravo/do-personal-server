package com.personal.management.deductionrate.filter.process;

import com.personal.management.deductionrate.entities.DeductionRate;
import com.personal.management.deductionrate.filter.inputs.FilterDeductionRateInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterDeductionRateProcess extends FunctionalProcess<FilterDeductionRateInput, DeductionRate> {

    public FilterDeductionRateProcess() {
        super("filter_deduction_rate_process");
    }

}
