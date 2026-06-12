package com.personal.business.orgrelation.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterOrgRelationInput extends BusinessFilterInputBase {

    private String structureId;
    private String hierarchyId;

    public FilterOrgRelationInput() {
        super();
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

}
