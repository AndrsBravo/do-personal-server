package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedOrgRelation extends ShortEntity {

    private SharedOrgStructure structure;
    private SharedOrgHierarchy hierarchy;

    public SharedOrgRelation() {
        super();
    }

    public SharedOrgRelation(String id) {
        super(id);
    }

    public SharedOrgStructure getStructure() {
        return structure;
    }

    public void setStructure(SharedOrgStructure structure) {
        this.structure = structure;
    }

    public SharedOrgHierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(SharedOrgHierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

}
