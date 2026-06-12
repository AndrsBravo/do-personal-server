package com.personal.backoffice.user.entities;

import com.personal.shared.entities.BaseEntity;
import com.personal.shared.entities.TypeEntityBase;

public class User extends BaseEntity {

    private String names;
    private String email;
    private String userName;
    private String lastNames;
    private TypeEntityBase userType;

    public User() {
        super();
    }

    public User(String id) {
        super(id);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public TypeEntityBase getUserType() {
        return userType;
    }

    public void setUserType(TypeEntityBase userType) {
        this.userType = userType;
    }

}
