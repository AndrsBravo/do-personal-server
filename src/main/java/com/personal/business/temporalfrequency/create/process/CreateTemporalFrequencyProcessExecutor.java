package com.personal.business.temporalfrequency.create.process;

import com.personal.business.temporalfrequency.create.process.rules.CreateTemporalFrequencyRule;
import com.personal.business.temporalfrequency.create.process.rules.ValidateTemporalFrequencyRule;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
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
