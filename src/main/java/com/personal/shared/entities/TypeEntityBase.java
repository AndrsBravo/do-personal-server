package com.personal.shared.entities;

public class TypeEntityBase extends ShortEntity {

    private String type;
    private String title;
    private String description;

    public TypeEntityBase() {
        super();
    }

    public TypeEntityBase(String id) {
        super(id);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
