package com.personal.backoffice.user.entities;

import com.personal.shared.entities.BaseEntity;

public class UserRole extends BaseEntity {

    private String role;
    private String title;
    private String description;

    public UserRole() {
        super();
    }

    public UserRole(String id) {
        super(id);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
