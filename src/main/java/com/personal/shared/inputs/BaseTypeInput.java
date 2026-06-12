package com.personal.shared.inputs;

import com.personal.shared.entities.TypeEntityBase;

public class BaseTypeInput extends Input {

    protected String type;
    protected String title;
    protected String description;

    public BaseTypeInput() {
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeEntityBase getType() {
        var userType = this.id == null || this.id.isEmpty() ? new TypeEntityBase() : new TypeEntityBase(this.id);
        userType.setType(type);
        userType.setTitle(title);
        userType.setDescription(description);
        userType.setCreatedBy(sessionUser);
        return userType;
    }
}
