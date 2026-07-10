package com.personal.management.temporalfrequency.filter.inputs;

import com.personal.backoffice.shared.inputs.CountryFilterInputBase;

public class FilterTemporalFrequencyInput extends CountryFilterInputBase {

    private String type;
    private String description;

    public FilterTemporalFrequencyInput() {
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
