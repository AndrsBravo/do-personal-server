package com.personal.backoffice.register.notifications;

import com.personal.backoffice.user.entities.User;
import com.personal.shared.notifications.Notification;

public class UserRegisterNotificationFactory {

    public static Notification UserValidationFail(User user) {
        return new Notification("Ha ocurrido un error de validación, mientras se creaba el usuario " + user.getNames());
    }

    public static Notification LoginFail(User user) {
        return new Notification("El usuario " + user.getEmail() + " no existe o la contraseña es incorrecta.");
    }

}
