package com.personal.management.temporalfrequency.update.process;

import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.temporalfrequency.update.process.rules.UpdateTemporalFrequencyRule;
import com.personal.management.temporalfrequency.update.process.rules.UpdateFieldsParamsTemporalFrequencyRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateTemporalFrequencyProcessExecutor extends SupplierProcessExecutor<UpdateTemporalFrequencyProcess, TemporalFrequency> {

    public UpdateTemporalFrequencyProcessExecutor() {
        super(new UpdateTemporalFrequencyProcess(),
                UpdateFieldsParamsTemporalFrequencyRule::new,
                UpdateTemporalFrequencyRule::new
        );
    }

    public static UpdateTemporalFrequencyProcessExecutor builder() {
        return new UpdateTemporalFrequencyProcessExecutor();
    }

}
