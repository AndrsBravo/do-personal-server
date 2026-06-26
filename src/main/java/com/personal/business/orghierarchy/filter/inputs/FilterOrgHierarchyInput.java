package com.personal.business.orghierarchy.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterOrgHierarchyInput extends BusinessFilterInputBase {

    private short level;
    private String title;
    private String hierarchy;
    private String description;

    public FilterOrgHierarchyInput() {
        super();
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
