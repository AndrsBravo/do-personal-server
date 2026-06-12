package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

/**
 * law, managed
 */
public class SharedTemporalFrequency extends ShortEntity {

    private String title;
    private String frequency;
    private String description;

    public SharedTemporalFrequency() {
        super();
    }

    public SharedTemporalFrequency(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
