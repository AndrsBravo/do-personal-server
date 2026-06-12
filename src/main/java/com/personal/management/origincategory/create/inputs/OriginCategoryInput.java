package com.personal.management.origincategory.create.inputs;

import com.personal.management.origincategory.entities.OriginCategory;
import com.personal.management.shared.inputs.CountryInputBase;

public class OriginCategoryInput extends CountryInputBase {

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

    public void setOrigin(String origin) {
        this.origin = origin;
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
