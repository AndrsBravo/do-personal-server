package com.personal.management.temporalfrequency.create.inputs;

import com.personal.management.shared.inputs.CountryInputBase;
import com.personal.management.temporalfrequency.entities.TemporalFrequency;

public class TemporalFrequencyInput extends CountryInputBase {

    private String title;
    private String frequency;
    private String description;

    public TemporalFrequencyInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public TemporalFrequency getTemporalFrequency() {
        var temporalFrequency = this.id == null || this.id.isEmpty() ? new TemporalFrequency() : new TemporalFrequency(this.id);
        temporalFrequency.setTitle(title);
        temporalFrequency.setFrequency(frequency);
        temporalFrequency.setDescription(description);
        temporalFrequency.setCreatedBy(sessionUser);
        return temporalFrequency;
    }
}
