package com.personal.backoffice.userrelation.create.inputs;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.shared.inputs.Input;

public class UserRelationInput extends Input {

    private String title;
    private String relation;
    private String description;

    public UserRelationInput() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public UserRelation getUserRelation() {
        var userRelation = this.id == null || this.id.isEmpty() ? new UserRelation() : new UserRelation(this.id);
        userRelation.setTitle(title);
        userRelation.setRelation(relation);
        userRelation.setDescription(description);
        userRelation.setCreatedBy(sessionUser);
        return userRelation;
    }
}
