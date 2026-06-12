package com.personal.business.payrollrun.filter.inputs;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterPayrollRunInput extends BusinessFilterInputBase {

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
