package com.personal.business.orghierarchy.create.inputs;

import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.shared.inputs.Input;

public class OrgHierarchyInput extends Input {

    private String title;
    private String entity;
    private String description;

    public OrgHierarchyInput() {
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

    public OrgHierarchy getOrgHierarchy() {
        var orgHierarchy = this.id == null || this.id.isEmpty() ? new OrgHierarchy() : new OrgHierarchy(this.id);
        orgHierarchy.setTitle(title);
        orgHierarchy.setHierarchy(entity);
        orgHierarchy.setDescription(description);
        orgHierarchy.setCreatedBy(sessionUser);
        return orgHierarchy;
    }
}
