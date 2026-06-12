package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedOrgStructure extends ShortEntity {

    private short level;
    private String title;
    private String charge;
    private String structure;
    private String description;

    public SharedOrgStructure() {
        super();
    }

    public SharedOrgStructure(String id) {
        super(id);
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getCharge() {
        return charge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
