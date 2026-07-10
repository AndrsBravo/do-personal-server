package com.personal.management.temporalfrequency.entities;

import com.personal.shared.core.entities.SharedCountry;
import com.personal.shared.core.entities.SharedTemporalFrequency;

public class TemporalFrequency extends SharedTemporalFrequency {

    private SharedCountry country;

    public TemporalFrequency() {
        super();
    }

    public TemporalFrequency(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
