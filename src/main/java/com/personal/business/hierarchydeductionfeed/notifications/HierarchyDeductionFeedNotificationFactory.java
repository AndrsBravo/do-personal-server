package com.personal.business.hierarchydeductionfeed.notifications;

import com.personal.shared.notifications.Notification;

public class HierarchyDeductionFeedNotificationFactory {

    public static Notification CreateHierarchyDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el valor de la deducción en la jerarquía ");
    }

    public static Notification CreateHierarchyDeductionFeedSuccess() {
        return new Notification("El valor de la deducción en la jerarquía se ha creado correctamente.");
    }

    public static Notification UpdateHierarchyDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el valor de la deducción en la jerarquía ");
    }

    public static Notification UpdateHierarchyDeductionFeedSuccess() {
        return new Notification("El valor de la deducción en la jerarquía se ha actualizado correctamente.");
    }

    public static Notification DeleteHierarchyDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el valor de la deducción en la jerarquía ");
    }

    public static Notification DeleteHierarchyDeductionFeedSuccess() {
        return new Notification("El valor de la deducción en la jerarquía se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
