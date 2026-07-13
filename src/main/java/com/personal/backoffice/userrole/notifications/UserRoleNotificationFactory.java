package com.personal.backoffice.userrole.notifications;

import com.personal.shared.notifications.Notification;

public class UserRoleNotificationFactory {

    public static Notification CreateUserRoleFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el role de usuario ");
    }

    public static Notification CreateUserRoleSuccess() {
        return new Notification("El role de usuario se ha creado exitosamente.");
    }

    public static Notification UpdateUserRoleFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el role de usuario ");
    }

    public static Notification UpdateUserRoleSuccess() {
        return new Notification("El role de usuario se ha actualizado exitosamente.");
    }

    public static Notification DeleteUserRoleFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el role de usuario ");
    }

    public static Notification DeleteUserRoleSuccess() {
        return new Notification("El role de usuario se ha eliminado exitosamente.");
    }

    public static Notification FetchUserRoleSuccess() {
        return new Notification("Lista de roles de usuarios.");
    }

    public static Notification FetchUserRoleFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los roles de usuarios.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
