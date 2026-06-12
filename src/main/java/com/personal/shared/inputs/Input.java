package com.personal.shared.inputs;

import com.personal.backoffice.user.entities.User;

import jakarta.validation.constraints.Size;

public class Input {

    @Size(min = 8, max = 12)
    protected String id;
    protected final User sessionUser;

    public Input() {
        // sessionUser = Contexts.globalContext().get("sessionUser", User.class).get();
        sessionUser = new User("H13A11L26A31");
    }

    public User getSessionUser() {
        return sessionUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
