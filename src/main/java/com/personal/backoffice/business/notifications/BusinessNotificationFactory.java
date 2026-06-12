package com.personal.backoffice.business.notifications;

import com.personal.shared.notifications.Notification;

public class BusinessNotificationFactory {

    public static Notification CreateBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de businesse ");
    }

    public static Notification UpdateBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de businesse ");
    }

    public static Notification DeleteBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de businesse ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
