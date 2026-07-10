package com.personal.business.user.notifications;

import com.personal.shared.notifications.Notification;

public class UserNotificationFactory {

    public static Notification CreateUserFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el usuario. ");
    }

    public static Notification CreateUserSuccess() {
        return new Notification("El usuario fue creado exitosamente.");
    }

    public static Notification UpdateUserFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el usuario ");
    }

    public static Notification UpdateUserSuccess() {
        return new Notification("El usuario se ha actualizado correctamente.");
    }

    public static Notification UserValidationFail() {
        return new Notification("Ha ocurrido un error de validación, mientras se creaba el usuario ");
    }

    public static Notification FetchUserEmpty(String filter) {
        return new Notification("No existen usuarios con los criterios de búsqueda: " + filter);
    }

}
