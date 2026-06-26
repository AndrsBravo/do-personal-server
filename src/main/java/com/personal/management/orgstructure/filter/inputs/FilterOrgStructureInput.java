package com.personal.management.orgstructure.filter.inputs;

import com.personal.management.shared.inputs.CountryFilterInputBase;

public class FilterOrgStructureInput extends CountryFilterInputBase {

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
