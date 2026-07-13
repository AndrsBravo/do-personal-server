package com.personal.backoffice.userrelation.notifications;

import com.personal.shared.notifications.Notification;

public class UserRelationNotificationFactory {

    public static Notification CreateUserRelationFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la relación de usuario ");
    }

    public static Notification CreateUserRelationSuccess() {
        return new Notification("La relación de usuario se ha creado correctamente ");
    }

    public static Notification UpdateUserRelationFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la relación de usuario ");
    }

    public static Notification UpdateUserRelationSuccess() {
        return new Notification("La relación de usuario se ha actualizado correctamente ");
    }

    public static Notification DeleteUserRelationFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la relación de usuario ");
    }

    public static Notification DeleteUserRelationSuccess() {
        return new Notification("La relación de usuario se ha eliminado correctamente ");
    }

    public static Notification FetchUserRelationSuccess() {
        return new Notification("Lista de relaciones de usuarios.");
    }

    public static Notification FetchUserRelationFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las relaciones de usuarios.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
