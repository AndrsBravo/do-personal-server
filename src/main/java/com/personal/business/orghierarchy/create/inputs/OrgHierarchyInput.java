package com.personal.business.orghierarchy.create.inputs;

import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.shared.inputs.BusinessInputBase;

public class OrgHierarchyInput extends BusinessInputBase {

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
        orgHierarchy.setBusiness(getBusiness());
        orgHierarchy.setCreatedBy(sessionUser);
        return orgHierarchy;
    }
}
