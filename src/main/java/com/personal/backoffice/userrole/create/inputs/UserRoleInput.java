package com.personal.backoffice.userrole.create.inputs;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.inputs.Input;

public class UserRoleInput extends Input {

    private String role;
    private String title;
    private String description;

    public UserRoleInput() {
        super();
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserRole getUserRole() {
        var userRole = this.id == null || this.id.isEmpty() ? new UserRole() : new UserRole(this.id);
        userRole.setRole(this.role);
        userRole.setTitle(this.title);
        userRole.setDescription(this.description);
        userRole.setCreatedBy(sessionUser);
        return userRole;
    }
}
