package com.personal.business.temporalfrequency.filter.process;

import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.business.temporalfrequency.filter.inputs.FilterTemporalFrequencyInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterTemporalFrequencyProcess extends FunctionalProcess<FilterTemporalFrequencyInput, TemporalFrequency> {

    public FilterTemporalFrequencyProcess() {
        super("filter_temporal_frequency_");
    }

}
