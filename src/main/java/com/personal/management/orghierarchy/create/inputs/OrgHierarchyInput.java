package com.personal.management.orghierarchy.create.inputs;

import com.personal.management.orghierarchy.entities.OrgHierarchy;
import com.personal.management.shared.inputs.CountryInputBase;

public class OrgHierarchyInput extends CountryInputBase {

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
