package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

/**
 * RT - Retencion GT - Gasto DT - Descuento
 *
 */
public class SharedDeductionCategory extends ShortEntity {

    private String title;
    private String category;
    private String description;

    public SharedDeductionCategory() {
        super();
    }

    public SharedDeductionCategory(String id) {
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

}
