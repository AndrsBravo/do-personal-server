package com.personal.backoffice.commercial.entity.create.inputs;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.shared.inputs.Input;

public class CommercialEntityInput extends Input {

    private String title;
    private String relation;
    private String description;

    public CommercialEntityInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEntity(String relation) {
        this.relation = relation;
    }

    public CommercialEntity getCommercialEntity() {
        var commercialEntity = this.id == null || this.id.isEmpty() ? new CommercialEntity() : new CommercialEntity(this.id);
        commercialEntity.setTitle(title);
        commercialEntity.setEntity(relation);
        commercialEntity.setDescription(description);
        commercialEntity.setCreatedBy(sessionUser);
        return commercialEntity;
    }
}
