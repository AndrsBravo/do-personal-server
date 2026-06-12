package com.personal.backoffice.user.entities;

import com.personal.shared.entities.BaseEntity;

public class UserRelation extends BaseEntity {

    private String title;
    private String relation;
    private String description;

    public UserRelation() {
        super();
    }

    public UserRelation(String id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
