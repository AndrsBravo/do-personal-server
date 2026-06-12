package com.personal.backoffice.commercial.plandetail.filter.inputs;

import com.personal.shared.inputs.FilterInput;

public class FilterCommercialPlanDetailInput extends FilterInput {

    private String type;
    private String description;

    public FilterCommercialPlanDetailInput() {
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
