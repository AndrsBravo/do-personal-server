package com.personal.management.temporalfrequency.filter.process;

import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.temporalfrequency.filter.inputs.FilterTemporalFrequencyInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterTemporalFrequencyProcess extends FunctionalProcess<FilterTemporalFrequencyInput, TemporalFrequency> {

    public FilterTemporalFrequencyProcess() {
        super("filter_temporal_frequency_");
    }

}
