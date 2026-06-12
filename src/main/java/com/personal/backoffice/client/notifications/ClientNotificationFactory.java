package com.personal.backoffice.client.notifications;

import com.personal.shared.notifications.Notification;

public class ClientNotificationFactory {

    public static Notification CreateClientFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el cliente ");
    }

    public static Notification UpdateClientFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el cliente ");
    }

    public static Notification DeleteClientFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el cliente ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

    public static Notification AddCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se agregaba el plan del cliente ");
    }

    public static Notification FilterCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se filtraban los planes del cliente ");
    }

}
