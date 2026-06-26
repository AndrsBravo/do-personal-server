package com.personal.management.orghierarchy.create.inputs;

import com.personal.management.orghierarchy.entities.OrgHierarchy;
import com.personal.management.shared.inputs.CountryInputBase;

public class OrgHierarchyInput extends CountryInputBase {

    private short level;
    private String title;
    private String hierarchy;
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

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public OrgHierarchy getOrgHierarchy() {
        var orgHierarchy = this.id == null || this.id.isEmpty() ? new OrgHierarchy() : new OrgHierarchy(this.id);
        orgHierarchy.setTitle(title);
        orgHierarchy.setLevel(level);
        orgHierarchy.setHierarchy(hierarchy);
        orgHierarchy.setDescription(description);
        orgHierarchy.setCountry(getCountry());
        orgHierarchy.setCreatedBy(sessionUser);
        return orgHierarchy;
    }
}
