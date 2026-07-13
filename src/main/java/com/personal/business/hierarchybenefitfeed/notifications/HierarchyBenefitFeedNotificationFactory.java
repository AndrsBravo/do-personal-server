package com.personal.business.hierarchybenefitfeed.notifications;

import com.personal.shared.notifications.Notification;

public class HierarchyBenefitFeedNotificationFactory {

    public static Notification CreateHierarchyBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el valor del beneficio en la jerarquía ");
    }

    public static Notification CreateHierarchyBenefitFeedSuccess() {
        return new Notification("El valor del beneficio en la jerarquía se ha creado correctamente.");
    }

    public static Notification UpdateHierarchyBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el valor del beneficio en la jerarquía ");
    }

    public static Notification UpdateHierarchyBenefitFeedSuccess() {
        return new Notification("El valor del beneficio en la jerarquía se ha actualizado correctamente.");
    }

    public static Notification DeleteHierarchyBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el valor del beneficio en la jerarquía ");
    }

    public static Notification DeleteHierarchyBenefitFeedSuccess() {
        return new Notification("El valor del beneficio en la jerarquía se ha eliminado correctamente.");
    }

    public static Notification FetchHierarchyBenefitFeedSuccess() {
        return new Notification("Lista de valores de beneficios de la jerarquía.");
    }

    public static Notification FetchHierarchyBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los valores de beneficios de la jerarquía.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
