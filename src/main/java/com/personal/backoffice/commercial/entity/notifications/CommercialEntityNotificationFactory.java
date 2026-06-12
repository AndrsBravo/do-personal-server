package com.personal.backoffice.commercial.entity.notifications;

import com.personal.shared.notifications.Notification;

public class CommercialEntityNotificationFactory {

    public static Notification CreateCommercialEntityFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateCommercialEntityFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteCommercialEntityFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
