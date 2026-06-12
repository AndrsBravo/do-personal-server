package com.personal.management.orgrelation.filter.inputs;

import com.personal.management.shared.inputs.CountryFilterInputBase;

public class FilterOrgRelationInput extends CountryFilterInputBase {

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
