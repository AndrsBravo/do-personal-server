package com.personal.business.financecategory.create.inputs;

import com.personal.business.financecategory.entities.FinanceCategory;
import com.personal.shared.inputs.Input;

public class FinanceCategoryInput extends Input {

    private String title;
    private String category;
    private String description;
    private Byte benefitOrDeduction;

    public FinanceCategoryInput() {
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

    public FinanceCategory getFinanceCategory() {
        var financeCategory = this.id == null || this.id.isEmpty() ? new FinanceCategory() : new FinanceCategory(this.id);
        financeCategory.setTitle(title);
        financeCategory.setCategory(category);
        financeCategory.setBenefitOrDeduction(benefitOrDeduction);
        financeCategory.setDescription(description);
        financeCategory.setCreatedBy(sessionUser);
        return financeCategory;
    }
}
