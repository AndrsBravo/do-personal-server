package com.personal.management.benefitcategory.filter.inputs;

import com.personal.management.shared.inputs.CountryFilterInputBase;

public class FilterBenefitCategoryInput extends CountryFilterInputBase {

    private String type;
    private String description;

    public FilterBenefitCategoryInput() {
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
