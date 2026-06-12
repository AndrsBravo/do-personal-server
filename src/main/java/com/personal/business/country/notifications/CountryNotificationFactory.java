package com.personal.business.country.notifications;

import com.personal.shared.notifications.Notification;

public class CountryNotificationFactory {

    public static Notification CreateCountryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de cliente ");
    }

    public static Notification UpdateCountryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de cliente ");
    }

    public static Notification DeleteCountryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de cliente ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
