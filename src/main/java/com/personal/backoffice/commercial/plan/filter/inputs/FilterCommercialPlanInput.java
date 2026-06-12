package com.personal.backoffice.commercial.plan.filter.inputs;

import com.personal.shared.inputs.FilterInput;

public class FilterCommercialPlanInput extends FilterInput {

    private String type;
    private String description;

    public FilterCommercialPlanInput() {
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
