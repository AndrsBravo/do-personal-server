package com.personal.backoffice.clienttype.notifications;

import com.personal.shared.notifications.Notification;

public class ClientTypeNotificationFactory {

    public static Notification CreateClientTypeFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de cliente ");
    }

    public static Notification UpdateClientTypeFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de cliente ");
    }

    public static Notification DeleteClientTypeFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de cliente ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
