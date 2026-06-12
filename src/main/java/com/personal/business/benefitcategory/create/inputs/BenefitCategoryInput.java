package com.personal.business.benefitcategory.create.inputs;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.shared.inputs.Input;

public class BenefitCategoryInput extends Input {

    private String title;
    private String entity;
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

    public void setCategory(String relation) {
        this.entity = relation;
    }

    public BenefitCategory getBenefitCategory() {
        var benefitCategory = this.id == null || this.id.isEmpty() ? new BenefitCategory() : new BenefitCategory(this.id);
        benefitCategory.setTitle(title);
        benefitCategory.setCategory(entity);
        benefitCategory.setDescription(description);
        benefitCategory.setCreatedBy(sessionUser);
        return benefitCategory;
    }
}
