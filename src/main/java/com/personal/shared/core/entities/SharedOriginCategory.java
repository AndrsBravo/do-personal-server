package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

/**
 * law, managed
 */
public class SharedOriginCategory extends ShortEntity {

    private String title;
    private String origin;
    private String description;

    public SharedOriginCategory() {
        super();
    }

    public SharedOriginCategory(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
