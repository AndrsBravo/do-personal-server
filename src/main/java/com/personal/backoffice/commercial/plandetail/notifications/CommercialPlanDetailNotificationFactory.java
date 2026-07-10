package com.personal.backoffice.commercial.plandetail.notifications;

import com.personal.shared.notifications.Notification;

public class CommercialPlanDetailNotificationFactory {

    public static Notification CreateCommercialPlanDetailFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el detalle plan comercial ");
    }

    public static Notification CreateCommercialPlanDetailSuccess() {
        return new Notification("El detalle plan comercial se ha creado correctamente.");
    }

    public static Notification UpdateCommercialPlanDetailFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el detalle plan comercial ");
    }

    public static Notification UpdateCommercialPlanDetailSuccess() {
        return new Notification("El detalle plan comercial se ha actualizado correctamente.");
    }

    public static Notification DeleteCommercialPlanDetailFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el detalle plan comercial ");
    }

    public static Notification DeleteCommercialPlanDetailSuccess() {
        return new Notification("El detalle plan comercial se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
