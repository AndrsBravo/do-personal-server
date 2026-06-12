package com.personal.business.structure.create.inputs;

import com.personal.business.structure.entities.Structure;
import com.personal.shared.inputs.Input;

public class StructureInput extends Input {

    private String title;
    private String entity;
    private String description;

    public StructureInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStructure(String relation) {
        this.entity = relation;
    }

    public Structure getStructure() {
        var structure = this.id == null || this.id.isEmpty() ? new Structure() : new Structure(this.id);
        structure.setTitle(title);
        structure.setStructure(entity);
        structure.setDescription(description);
        structure.setCreatedBy(sessionUser);
        return structure;
    }
}
