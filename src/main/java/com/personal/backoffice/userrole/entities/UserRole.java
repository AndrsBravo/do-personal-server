package com.personal.backoffice.userrole.entities;

import com.personal.shared.entities.ShortEntity;

public class UserRole extends ShortEntity {

    private String role;
    private String title;
    private String description;

    public UserRole() {
        super();
    }

    public UserRole(String id) {
        super(id);
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
