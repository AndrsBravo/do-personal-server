package com.personal.management.temporalfrequency.delete.process;

import com.personal.management.temporalfrequency.delete.process.rules.DeleteTemporalFrequencyRule;
import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteTemporalFrequencyProcessExecutor extends SupplierProcessExecutor<DeleteTemporalFrequencyProcess, TemporalFrequency> {

    public DeleteTemporalFrequencyProcessExecutor() {
        super(new DeleteTemporalFrequencyProcess(),
                DeleteTemporalFrequencyRule::new
        );
    }

    public static DeleteTemporalFrequencyProcessExecutor builder() {
        return new DeleteTemporalFrequencyProcessExecutor();
    }

}
