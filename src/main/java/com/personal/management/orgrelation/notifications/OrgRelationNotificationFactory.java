package com.personal.management.orgrelation.notifications;

import com.personal.shared.notifications.Notification;

public class OrgRelationNotificationFactory {

    public static Notification CreateOrgRelationFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la relación organizacional ");
    }

    public static Notification CreateOrgRelationSuccess() {
        return new Notification("La relación organizacional se ha creado correctamente.");
    }

    public static Notification UpdateOrgRelationFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la relación organizacional ");
    }

    public static Notification UpdateOrgRelationSuccess() {
        return new Notification("La relación organizacional se ha actualizado correctamente.");
    }

    public static Notification DeleteOrgRelationFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la relación organizacional ");
    }

    public static Notification DeleteOrgRelationSuccess() {
        return new Notification("La relación organizacional se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
