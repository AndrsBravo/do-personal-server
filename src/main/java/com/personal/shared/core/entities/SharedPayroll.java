package com.personal.shared.core.entities;

import com.personal.shared.entities.BaseEntity;

public class SharedPayroll extends BaseEntity {

    private String title;
    private String payroll;
    private String description;
    private SharedTemporalFrequency temporalFrequency;

    public SharedPayroll() {
        super();
    }

    public SharedPayroll(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPayroll() {
        return payroll;
    }

    public void setPayroll(String benefit) {
        this.payroll = benefit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SharedTemporalFrequency getTemporalFrequency() {
        return temporalFrequency;
    }

    public void setTemporalFrequency(SharedTemporalFrequency temporalFrequency) {
        this.temporalFrequency = temporalFrequency;
    }

}
