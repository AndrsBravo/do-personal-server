package com.personal.management.temporalfrequency.create.process;

import com.personal.management.temporalfrequency.create.process.rules.CreateTemporalFrequencyRule;
import com.personal.management.temporalfrequency.create.process.rules.ValidateTemporalFrequencyRule;
import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateTemporalFrequencyProcessExecutor extends SupplierProcessExecutor<CreateTemporalFrequencyProcess, TemporalFrequency> {

    public CreateTemporalFrequencyProcessExecutor() {
        super(new CreateTemporalFrequencyProcess(),
                ValidateTemporalFrequencyRule::new,
                CreateTemporalFrequencyRule::new
        );
    }

    public static CreateTemporalFrequencyProcessExecutor builder() {
        return new CreateTemporalFrequencyProcessExecutor();
    }

}
