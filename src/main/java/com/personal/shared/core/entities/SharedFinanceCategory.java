package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

/**
 * mo, nomo
 */
public class SharedFinanceCategory extends ShortEntity {

    private String title;
    private String category;
    private String description;
    private Byte benefitOrDeduction;

    public SharedFinanceCategory() {
        super();
    }

    public SharedFinanceCategory(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getBenefitOrDeduction() {
        return benefitOrDeduction;
    }

    public void setBenefitOrDeduction(Byte benefitOrDeduction) {
        this.benefitOrDeduction = benefitOrDeduction;
    }

}
