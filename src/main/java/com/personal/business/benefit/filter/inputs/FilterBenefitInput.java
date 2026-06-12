package com.personal.business.benefit.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterBenefitInput extends BusinessFilterInputBase {

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
