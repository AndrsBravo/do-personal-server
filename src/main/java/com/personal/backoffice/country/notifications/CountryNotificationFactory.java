package com.personal.backoffice.country.notifications;

import com.personal.shared.notifications.Notification;

public class CountryNotificationFactory {

    public static Notification CreateCountryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el país: ");
    }

    public static Notification CreateCountrySuccess() {
        return new Notification("El país se ha creado correctamente");
    }

    public static Notification UpdateCountryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el país: ");
    }

    public static Notification UpdateCountrySuccess() {
        return new Notification("El país se ha actualizado correctamente");
    }

    public static Notification DeleteCountryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el país: ");
    }

    public static Notification DeleteCountrySuccess() {
        return new Notification("El país se ha eliminado correctamente");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados: ");
    }

}
