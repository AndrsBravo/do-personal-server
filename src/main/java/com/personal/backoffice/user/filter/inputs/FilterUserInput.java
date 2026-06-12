package com.personal.backoffice.user.filter.inputs;

import com.personal.shared.inputs.FilterInput;

import jakarta.validation.constraints.Email;

public class FilterUserInput extends FilterInput {

    String user_name;
    @Email(message = "Debe colocar un email Valido.")
    String email;

    public FilterUserInput() {
        super();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return user_name;
    }

}
