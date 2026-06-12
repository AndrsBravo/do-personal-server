package com.personal.business.temporalfrequency.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedTemporalFrequency;

public class TemporalFrequency extends SharedTemporalFrequency {

    private Business business;

    public TemporalFrequency() {
        super();
    }

    public TemporalFrequency(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
