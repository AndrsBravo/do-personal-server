package com.personal.management.deductioncategory.create.inputs;

import com.personal.backoffice.shared.inputs.CountryInputBase;
import com.personal.management.deductioncategory.entities.DeductionCategory;

public class DeductionCategoryInput extends CountryInputBase {

    private String title;
    private String category;
    private String description;

    public DeductionCategoryInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String relation) {
        this.category = relation;
    }

    public DeductionCategory getDeductionCategory() {
        var deductionCategory = this.id == null || this.id.isEmpty() ? new DeductionCategory() : new DeductionCategory(this.id);
        deductionCategory.setTitle(title);
        deductionCategory.setCategory(category);
        deductionCategory.setDescription(description);
        deductionCategory.setCreatedBy(sessionUser);
        return deductionCategory;
    }
}
