package com.personal.backoffice.register.password.inputs;

import com.personal.backoffice.user.entities.Credentials;
import com.personal.shared.inputs.Input;

public class UserCredentialsInput extends Input {

    private String userId;
    private String password;
    private String password2;
    private Credentials credentials;

    public UserCredentialsInput() {
        super();
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Credentials getCredentials() {
        return credentials;
    }

}
