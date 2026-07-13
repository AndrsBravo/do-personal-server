package com.personal.backoffice.client.notifications;

import com.personal.shared.notifications.Notification;

public class ClientNotificationFactory {

    public static Notification CreateClientFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el cliente ");
    }

    public static Notification CreateClientSuccess() {
        return new Notification("El cliente ha sido creado correctamente.");
    }

    public static Notification UpdateClientFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el cliente ");
    }

    public static Notification UpdateClientSuccess() {
        return new Notification("El cliente ha sido actualizado correctamente.");
    }

    public static Notification DeleteClientFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el cliente ");
    }

    public static Notification DeleteClientSuccess() {
        return new Notification("El cliente ha sido eliminado correctamente");
    }

    public static Notification FetchClientSuccess() {
        return new Notification("Lista de Clientes.");
    }

    public static Notification FetchClientFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban la clientes.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

    public static Notification AddCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se agregaba el plan del cliente ");
    }

    public static Notification AddCommercialPlanSuccessful() {
        return new Notification("El plan del cliente ha sido agregado correctamente.");
    }

    public static Notification FilterCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se filtraban los planes del cliente ");
    }

}
