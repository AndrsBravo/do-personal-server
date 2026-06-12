package com.personal.business.orgrelation.create.inputs;

import com.personal.business.orgrelation.entities.OrgRelation;
import com.personal.shared.core.entities.SharedOrgHierarchy;
import com.personal.shared.core.entities.SharedOrgStructure;
import com.personal.shared.inputs.BusinessInputBase;

public class OrgRelationInput extends BusinessInputBase {

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
        orgRelation.setCreatedBy(sessionUser);
        return orgRelation;
    }
}
