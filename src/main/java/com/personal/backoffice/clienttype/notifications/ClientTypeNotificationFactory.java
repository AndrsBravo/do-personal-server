package com.personal.backoffice.clienttype.notifications;

import com.personal.shared.notifications.Notification;

public class ClientTypeNotificationFactory {

    public static Notification CreateClientTypeFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de cliente ");
    }

    public static Notification CreateClientTypeSuccess() {
        return new Notification("El tipo de cliente se ha creado exitosamente ");
    }

    public static Notification UpdateClientTypeFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de cliente ");
    }

    public static Notification UpdateClientTypeSuccess() {
        return new Notification("El tipo de cliente se ha actualizado exitosamente ");
    }

    public static Notification DeleteClientTypeFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de cliente ");
    }

    public static Notification DeleteClientTypeSuccess() {
        return new Notification("El tipo de cliente ha sido eliminado exitosamente. ");
    }

    public static Notification FetchClientTypeSuccess() {
        return new Notification("Lista de tipos de clientes. ");
    }

    public static Notification FetchClientTypeFail() {
        return new Notification("Ha ocurrido un error al consultar los tipos de clientes. ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
