package com.personal.business.temporalfrequency.create.inputs;

import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.inputs.Input;

public class TemporalFrequencyInput extends Input {

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
