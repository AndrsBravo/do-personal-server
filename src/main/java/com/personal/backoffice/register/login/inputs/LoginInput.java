package com.personal.backoffice.register.login.inputs;

import com.personal.backoffice.user.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginInput {

    @NotBlank(message = "El 'Nombre de Usuario' es obligatorio")
    @Size(min = 6, max = 28, message = "El Nombre de Usuario 'userName', debe tener un mínimo de 6 Caracteres y un Máximo de 28")
    private String userName;
    @NotBlank
    @Email(message = "Debe colocar un email Valido.")
    private String email;
    @NotBlank
    @Size(min = 8, max = 60, message = "La contraseña debe tener un mínimo de 8 Caracteres y un Máximo de 60")
    private String password;

    public LoginInput() {
        super();
    }

    public LoginInput(@NotBlank @Email(message = "Debe colocar un email Valido.") String email,
            @NotBlank @Size(min = 8, max = 60, message = "La contraseña debe tener un mínimo de 8 Caracteres y un Máximo de 60") String password) {
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        var result = new User();
        result.setUserName(userName);
        result.setEmail(email);
        return result;

    }

}
