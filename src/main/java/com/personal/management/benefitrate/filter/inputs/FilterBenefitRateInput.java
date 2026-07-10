package com.personal.management.benefitrate.filter.inputs;

import com.personal.backoffice.shared.inputs.CountryFilterInputBase;

public class FilterBenefitRateInput extends CountryFilterInputBase {

    private String type;
    private String description;

    public FilterBenefitRateInput() {
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
