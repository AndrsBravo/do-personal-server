package com.personal.management.orghierarchy.notifications;

import com.personal.shared.notifications.Notification;

public class OrgHierarchyNotificationFactory {

    public static Notification CreateOrgHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la jerarquía organizacional ");
    }

    public static Notification CreateOrgHierarchySuccess() {
        return new Notification("La jerarquía organizacional se ha creado correctamente.");
    }

    public static Notification UpdateOrgHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la jerarquía organizacional ");
    }

    public static Notification UpdateOrgHierarchySuccess() {
        return new Notification("La jerarquía organizacional se ha actualizado correctamente.");
    }

    public static Notification DeleteOrgHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la jerarquía organizacional ");
    }

    public static Notification DeleteOrgHierarchySuccess() {
        return new Notification("La jerarquía organizacional se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
