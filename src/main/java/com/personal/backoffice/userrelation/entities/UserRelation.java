package com.personal.backoffice.userrelation.entities;

import com.personal.shared.entities.ShortEntity;

public class UserRelation extends ShortEntity {

    private String title;
    private String relation;
    private String description;

    public UserRelation() {
        super();
    }

    public UserRelation(String id) {
        super(id);
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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
