package com.personal.management.orgrelation.create.inputs;

import com.personal.management.orgrelation.entities.OrgRelation;
import com.personal.management.shared.inputs.CountryInputBase;
import com.personal.shared.core.entities.SharedOrgHierarchy;
import com.personal.shared.core.entities.SharedOrgStructure;

public class OrgRelationInput extends CountryInputBase {

    private String structureId;
    private String hierarchyId;

    public OrgRelationInput() {
        super();
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public OrgRelation getOrgRelation() {
        var orgRelation = this.id == null || this.id.isEmpty() ? new OrgRelation() : new OrgRelation(this.id);
        orgRelation.setStructure(new SharedOrgStructure(structureId));
        orgRelation.setHierarchy(new SharedOrgHierarchy(hierarchyId));
        orgRelation.setCountry(getCountry());
        orgRelation.setCreatedBy(sessionUser);
        return orgRelation;
    }
}
