package com.personal.backoffice.commercial.plan.notifications;

import com.personal.shared.notifications.Notification;

public class CommercialPlanNotificationFactory {

    public static Notification CreateCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
