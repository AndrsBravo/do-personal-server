package com.personal.management.orgstructure.notifications;

import com.personal.shared.notifications.Notification;

public class OrgStructureNotificationFactory {

    public static Notification CreateOrgStructureFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la estructura organizacional ");
    }

    public static Notification CreateOrgStructureSuccess() {
        return new Notification("La estructura organizacional se ha creado correctamente.");
    }

    public static Notification UpdateOrgStructureFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la estructura organizacional ");
    }

    public static Notification UpdateOrgStructureSuccess() {
        return new Notification("La estructura organizacional se ha actualizado correctamente.");
    }

    public static Notification DeleteOrgStructureFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la estructura organizacional ");
    }

    public static Notification DeleteOrgStructureSuccess() {
        return new Notification("La estructura organizacional se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
