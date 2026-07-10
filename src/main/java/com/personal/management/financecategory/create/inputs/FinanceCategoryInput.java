package com.personal.management.financecategory.create.inputs;

import com.personal.backoffice.shared.inputs.CountryInputBase;
import com.personal.management.financecategory.entities.FinanceCategory;

public class FinanceCategoryInput extends CountryInputBase {

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
