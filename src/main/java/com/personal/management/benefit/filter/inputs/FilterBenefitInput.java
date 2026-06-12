package com.personal.management.benefit.filter.inputs;

import com.personal.management.shared.inputs.CountryFilterInputBase;

public class FilterBenefitInput extends CountryFilterInputBase {

    private String type;
    private String description;

    public FilterBenefitInput() {
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
