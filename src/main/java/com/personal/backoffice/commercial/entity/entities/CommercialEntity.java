package com.personal.backoffice.commercial.entity.entities;

import com.personal.shared.entities.ShortEntity;

public class CommercialEntity extends ShortEntity {

    private String entity;
    private String title;
    private String description;

    public CommercialEntity() {
        super();
    }

    public CommercialEntity(String id) {
        super(id);
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
