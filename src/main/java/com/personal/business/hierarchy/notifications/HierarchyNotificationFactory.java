package com.personal.business.hierarchy.notifications;

import com.personal.shared.notifications.Notification;

public class HierarchyNotificationFactory {

    public static Notification CreateHierarchySuccess() {
        return new Notification("La jerarquía se ha creado correctamente.");
    }

    public static Notification CreateHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la jerarquía ");
    }

    public static Notification UpdateHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la jerarquía ");
    }

    public static Notification UpdateHierarchySuccess() {
        return new Notification("La jerarquía se ha actualizado correctamente.");
    }

    public static Notification DeleteHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la jerarquía ");
    }

    public static Notification DeleteHierarchySuccess() {
        return new Notification("La jerarquía se ha eliminado correctamente.");
    }

    public static Notification FetchHierarchySuccess() {
        return new Notification("Lista de jerarquías.");
    }

    public static Notification FetchHierarchyFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las jerarquías.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
