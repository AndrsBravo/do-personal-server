package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedBenefit extends ShortEntity {

    private String title;
    private String benefit;
    private String description;
    private SharedBenefitCategory category;

    public SharedBenefit() {
        super();
    }

    public SharedBenefit(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SharedBenefitCategory getCategory() {
        return category;
    }

    public void setCategory(SharedBenefitCategory category) {
        this.category = category;
    }

}
