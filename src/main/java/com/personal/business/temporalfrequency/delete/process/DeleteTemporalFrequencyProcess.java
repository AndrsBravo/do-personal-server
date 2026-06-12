package com.personal.business.temporalfrequency.delete.process;

import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.process.SupplierProcess;

public class DeleteTemporalFrequencyProcess extends SupplierProcess<TemporalFrequency> {

    public DeleteTemporalFrequencyProcess() {
        super("delete_temporal_frequency_process");
    }

}
