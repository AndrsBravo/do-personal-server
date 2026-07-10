package com.personal.business.hierarchydeduction.notifications;

import com.personal.shared.notifications.Notification;

public class HierarchyDeductionNotificationFactory {

    public static Notification CreateHierarchyDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la deducción en la jerarquía ");
    }

    public static Notification CreateHierarchyDeductionSuccess() {
        return new Notification("La deducción en la jerarquía se ha creado correctamente.");
    }

    public static Notification UpdateHierarchyDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la deducción en la jerarquía ");
    }

    public static Notification UpdateHierarchyDeductionSuccess() {
        return new Notification("La deducción en la jerarquía se ha actualizado correctamente.");
    }

    public static Notification DeleteHierarchyDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la deducción en la jerarquía ");
    }

    public static Notification DeleteHierarchyDeductionSuccess() {
        return new Notification("La deducción en la jerarquía se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
