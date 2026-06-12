package com.personal.backoffice.user.create.inputs;

import com.personal.backoffice.user.entities.User;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.inputs.Input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInput extends Input {

    @Size(max = 12, min = 12, message = "El ID debe tener 12 Caracteres")
    private String userTypeid;
    @NotBlank(message = "El 'Nombre de Usuario' es obligatorio")
    @Size(min = 6, max = 28, message = "El Nombre de Usuario 'userName', debe tener un mínimo de 6 Caracteres y un Máximo de 28")
    private String userName;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email(message = "Debe colocar un email Valido.")
    private String email;

    public UserInput() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserTypeid(String userTypeid) {
        this.userTypeid = userTypeid;
    }

    public User getUser() {
        var result = this.id != null ? new User(this.id) : new User();
        var userType = this.userTypeid == null ? new TypeEntityBase(this.userTypeid) : new TypeEntityBase();
        result.setUserType(userType);
        result.setUserName(userName);
        result.setNames(name);
        result.setLastNames(lastName);
        result.setEmail(email);
        result.setCreatedBy(this.getSessionUser());
        return result;

    }

}
