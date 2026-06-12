package com.personal.backoffice.user.entities;

import com.personal.shared.entities.BaseEntity;

public class Credentials extends BaseEntity {

    private String userId;
    private String password;
    private byte[] salt;

    public Credentials() {
        super();
    }

    public Credentials(String id) {
        super(id);
    }

    public Credentials(String password, byte[] salt) {
        this.password = password;
        this.salt = salt;
    }

    public String password() {
        return password;
    }

    public byte[] salt() {
        return salt;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

}
