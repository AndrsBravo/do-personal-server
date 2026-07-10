package com.personal.management.temporalfrequency.notifications;

import com.personal.shared.notifications.Notification;

public class TemporalFrequencyNotificationFactory {

    public static Notification CreateTemporalFrequencyFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la frecuencia temporal ");
    }

    public static Notification CreateTemporalFrequencySuccess() {
        return new Notification("La frecuencia temporal se ha creado correctamente.");
    }

    public static Notification UpdateTemporalFrequencyFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la frecuencia temporal ");
    }

    public static Notification DeleteTemporalFrequencyFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la frecuencia temporal ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
