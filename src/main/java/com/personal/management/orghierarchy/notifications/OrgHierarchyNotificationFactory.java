package com.personal.management.orghierarchy.notifications;

import com.personal.shared.notifications.Notification;

public class OrgHierarchyNotificationFactory {

    public static Notification CreateOrgHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateOrgHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteOrgHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
