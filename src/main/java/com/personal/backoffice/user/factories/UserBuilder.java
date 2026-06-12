package com.personal.backoffice.user.factories;

import com.personal.backoffice.user.entities.User;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        this.user = new User();
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder withId(String id) {
        this.user.setId(id);
        return this;
    }

    public UserBuilder withNames(String names) {
        this.user.setNames(names);
        return this;
    }

    public UserBuilder withLastNames(String lastNames) {
        this.user.setLastNames(lastNames);
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.user.setEmail(email);
        return this;
    }

    public UserBuilder withUserName(String userName) {
        this.user.setUserName(userName);
        return this;
    }

    public User build() {
        return this.user;
    }
}
