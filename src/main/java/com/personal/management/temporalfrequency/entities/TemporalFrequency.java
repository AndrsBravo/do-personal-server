package com.personal.management.temporalfrequency.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedTemporalFrequency;

public class TemporalFrequency extends SharedTemporalFrequency {

    private Country country;

    public TemporalFrequency() {
        super();
    }

    public TemporalFrequency(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
