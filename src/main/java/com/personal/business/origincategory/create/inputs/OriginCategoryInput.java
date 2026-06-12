package com.personal.business.origincategory.create.inputs;

import com.personal.business.origincategory.entities.OriginCategory;
import com.personal.shared.inputs.Input;

public class OriginCategoryInput extends Input {

    private String title;
    private String origin;
    private String description;

    public OriginCategoryInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrigin(String relation) {
        this.origin = relation;
    }

    public OriginCategory getOriginCategory() {
        var originCategory = this.id == null || this.id.isEmpty() ? new OriginCategory() : new OriginCategory(this.id);
        originCategory.setTitle(title);
        originCategory.setOrigin(origin);
        originCategory.setDescription(description);
        originCategory.setCreatedBy(sessionUser);
        return originCategory;
    }
}
