package com.personal.management.temporalfrequency.notifications;

import com.personal.shared.notifications.Notification;

public class TemporalFrequencyNotificationFactory {

    public static Notification CreateTemporalFrequencyFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateTemporalFrequencyFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteTemporalFrequencyFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
