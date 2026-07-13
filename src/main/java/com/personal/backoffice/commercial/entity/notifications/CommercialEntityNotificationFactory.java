package com.personal.backoffice.commercial.entity.notifications;

import com.personal.shared.notifications.Notification;

public class CommercialEntityNotificationFactory {

    public static Notification CreateCommercialEntityFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la entidad ");
    }

    public static Notification CreateCommercialEntitySuccess() {
        return new Notification("La entidad se ha creado exitosamente ");
    }

    public static Notification UpdateCommercialEntityFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la entidad ");
    }

    public static Notification UpdateCommercialEntitySuccess() {
        return new Notification("La entidad se ha actualizado exitosamente ");
    }

    public static Notification DeleteCommercialEntityFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la entidad ");
    }

    public static Notification DeleteCommercialEntitySuccess() {
        return new Notification("La entidad ha sido eliminada exitosamente. ");
    }

    public static Notification FetchCommercialEntitySuccess() {
        return new Notification("Lista de empresas.");
    }

    public static Notification FetchCommercialEntityFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las entidades comerciales.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
