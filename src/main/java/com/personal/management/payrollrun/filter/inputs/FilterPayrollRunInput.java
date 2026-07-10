package com.personal.management.payrollrun.filter.inputs;

import com.personal.backoffice.shared.inputs.CountryFilterInputBase;

public class FilterPayrollRunInput extends CountryFilterInputBase {

    private String type;
    private String description;

    public FilterPayrollRunInput() {
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
