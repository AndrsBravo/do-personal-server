package com.personal.backoffice.usertype.notifications;

import com.personal.shared.notifications.Notification;

public class UserTypeNotificationFactory {

    public static Notification CreateUserTypeFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification CreateUserTypeSuccess() {
        return new Notification("El tipo de usuario se ha creado correctamente.");
    }

    public static Notification UpdateUserTypeFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification UpdateUserTypeSuccess() {
        return new Notification("El tipo de usuario se ha actualizado correctamente.");
    }

    public static Notification DeleteUserTypeFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification DeleteUserTypeSuccess() {
        return new Notification("El tipo de usuario se ha eliminado correctamente.");
    }

    public static Notification FetchUserTypeSuccess() {
        return new Notification("Lista de tipos de usuarios.");
    }

    public static Notification FetchUserTypeFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los tipos de usuarios.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
