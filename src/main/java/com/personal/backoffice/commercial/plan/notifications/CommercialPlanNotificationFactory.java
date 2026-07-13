package com.personal.backoffice.commercial.plan.notifications;

import com.personal.shared.notifications.Notification;

public class CommercialPlanNotificationFactory {

    public static Notification CreateCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el plan comercial ");
    }

    public static Notification CreateCommercialPlanSuccess() {
        return new Notification("El plan comercial se ha creado correctamente.");
    }

    public static Notification UpdateCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el plan comercial ");
    }

    public static Notification UpdateCommercialPlanSuccess() {
        return new Notification("El plan comercial se ha actualizado correctamente.");
    }

    public static Notification DeleteCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el plan comercial ");
    }

    public static Notification DeleteCommercialPlanSuccess() {
        return new Notification("El plan comercial se ha eliminado exitosamente. ");
    }

    public static Notification FetchCommercialPlanSuccess() {
        return new Notification("Lista de Planes Comerciales.");
    }

    public static Notification FetchCommercialPlanFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los planes comerciales.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
