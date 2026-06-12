package com.personal.management.orgstructure.create.inputs;

import com.personal.management.orgstructure.entities.OrgStructure;
import com.personal.management.shared.inputs.CountryInputBase;

public class OrgStructureInput extends CountryInputBase {

    private String title;
    private String entity;
    private String description;

    public OrgStructureInput() {
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

    public OrgStructure getOrgStructure() {
        var orgStructure = this.id == null || this.id.isEmpty() ? new OrgStructure() : new OrgStructure(this.id);
        orgStructure.setTitle(title);
        orgStructure.setStructure(entity);
        orgStructure.setDescription(description);
        orgStructure.setCreatedBy(sessionUser);
        return orgStructure;
    }
}
