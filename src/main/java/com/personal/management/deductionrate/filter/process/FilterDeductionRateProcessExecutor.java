package com.personal.management.deductionrate.filter.process;

import com.personal.management.deductionrate.entities.DeductionRate;
import com.personal.management.deductionrate.filter.inputs.FilterDeductionRateInput;
import com.personal.management.deductionrate.filter.process.rules.FilterDeductionRateRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterDeductionRateProcessExecutor extends FunctionalProcessExecutor<FilterDeductionRateProcess, FilterDeductionRateInput, DeductionRate> {

    public FilterDeductionRateProcessExecutor() {
        super(new FilterDeductionRateProcess(), FilterDeductionRateRule::new);
    }

    public static FilterDeductionRateProcessExecutor builder() {
        return new FilterDeductionRateProcessExecutor();
    }

}
