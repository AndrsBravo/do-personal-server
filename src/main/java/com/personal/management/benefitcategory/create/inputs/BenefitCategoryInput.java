package com.personal.management.benefitcategory.create.inputs;

import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.management.shared.inputs.CountryInputBase;

public class BenefitCategoryInput extends CountryInputBase {

    private String title;
    private String category;
    private String description;

    public BenefitCategoryInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BenefitCategory getBenefitCategory() {
        var benefitCategory = this.id == null || this.id.isEmpty() ? new BenefitCategory() : new BenefitCategory(this.id);
        benefitCategory.setTitle(title);
        benefitCategory.setCategory(category);
        benefitCategory.setDescription(description);
        benefitCategory.setCreatedBy(sessionUser);
        return benefitCategory;
    }
}
