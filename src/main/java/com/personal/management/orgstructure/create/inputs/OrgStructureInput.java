package com.personal.management.orgstructure.create.inputs;

import com.personal.management.orgstructure.entities.OrgStructure;
import com.personal.management.shared.inputs.CountryInputBase;

public class OrgStructureInput extends CountryInputBase {

    private short level;
    private String title;
    private String structure;
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

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public OrgStructure getOrgStructure() {
        var orgStructure = this.id == null || this.id.isEmpty() ? new OrgStructure() : new OrgStructure(this.id);
        orgStructure.setTitle(title);
        orgStructure.setLevel(level);
        orgStructure.setStructure(structure);
        orgStructure.setDescription(description);
        orgStructure.setCreatedBy(sessionUser);
        orgStructure.setCountry(this.getCountry());
        return orgStructure;
    }
}
