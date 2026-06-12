package com.personal.management.temporalfrequency.filter.process;

import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.temporalfrequency.filter.inputs.FilterTemporalFrequencyInput;
import com.personal.management.temporalfrequency.filter.process.rules.FilterTemporalFrequencyRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterTemporalFrequencyProcessExecutor extends FunctionalProcessExecutor<FilterTemporalFrequencyProcess, FilterTemporalFrequencyInput, TemporalFrequency> {

    public FilterTemporalFrequencyProcessExecutor() {
        super(new FilterTemporalFrequencyProcess(), FilterTemporalFrequencyRule::new);
    }

    public static FilterTemporalFrequencyProcessExecutor builder() {
        return new FilterTemporalFrequencyProcessExecutor();
    }

}
