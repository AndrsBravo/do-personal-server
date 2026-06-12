package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedOrgHierarchy extends ShortEntity {

    private short level;
    private String hierarchy;
    private String title;
    private String description;

    public SharedOrgHierarchy() {
        super();
    }

    public SharedOrgHierarchy(String id) {
        super(id);
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
