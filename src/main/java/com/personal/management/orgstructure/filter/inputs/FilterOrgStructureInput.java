package com.personal.management.orgstructure.filter.inputs;

import com.personal.management.shared.inputs.CountryFilterInputBase;

public class FilterOrgStructureInput extends CountryFilterInputBase {

    private String type;
    private String description;

    public FilterOrgStructureInput() {
        super();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
