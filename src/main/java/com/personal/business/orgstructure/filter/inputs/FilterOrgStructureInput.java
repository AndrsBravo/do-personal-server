package com.personal.business.orgstructure.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterOrgStructureInput extends BusinessFilterInputBase {

    private short level;
    private String title;
    private String structure;
    private String description;

    public FilterOrgStructureInput() {
        super();
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public short getLevel() {
        return level;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getStructure() {
        return structure;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
