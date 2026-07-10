package com.personal.management.deduction.filter.inputs;

import com.personal.backoffice.shared.inputs.CountryFilterInputBase;

public class FilterDeductionInput extends CountryFilterInputBase {

    private String type;
    private String description;

    public FilterDeductionInput() {
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
