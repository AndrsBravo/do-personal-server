package com.personal.business.hierarchy.create.inputs;

import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.shared.inputs.Input;

public class HierarchyInput extends Input {

    private String title;
    private String entity;
    private String description;

    public HierarchyInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHierarchy(String relation) {
        this.entity = relation;
    }

    public Hierarchy getHierarchy() {
        var hierarchy = this.id == null || this.id.isEmpty() ? new Hierarchy() : new Hierarchy(this.id);
        hierarchy.setTitle(title);
        hierarchy.setHierarchy(entity);
        hierarchy.setDescription(description);
        hierarchy.setCreatedBy(sessionUser);
        return hierarchy;
    }
}
