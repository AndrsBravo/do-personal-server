package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedBenefitCategory extends ShortEntity {

    private String title;
    private String category;
    private String description;
    private SharedFinanceCategory financeType;
    private SharedOriginCategory origin;

    public SharedBenefitCategory() {
        super();
    }

    public SharedBenefitCategory(String id) {
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

    public SharedFinanceCategory getFinanceType() {
        return financeType;
    }

    public void setFinanceType(SharedFinanceCategory financeType) {
        this.financeType = financeType;
    }

    public void setOrigin(SharedOriginCategory origin) {
        this.origin = origin;
    }

    public SharedOriginCategory getOrigin() {
        return origin;
    }

}
