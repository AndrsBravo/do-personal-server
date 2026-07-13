package com.personal.business.hierarchybenefit.notifications;

import com.personal.shared.notifications.Notification;

public class HierarchyBenefitNotificationFactory {

    public static Notification CreateHierarchyBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el beneficio en la jerarquía ");
    }

    public static Notification CreateHierarchyBenefitSuccess() {
        return new Notification("El beneficio en la jerarquía se ha creado correctamente.");
    }

    public static Notification UpdateHierarchyBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el beneficio en la jerarquía ");
    }

    public static Notification UpdateHierarchyBenefitSuccess() {
        return new Notification("El beneficio en la jerarquía se ha actualizado correctamente.");
    }

    public static Notification DeleteHierarchyBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el beneficio en la jerarquía ");
    }

    public static Notification DeleteHierarchyBenefitSuccess() {
        return new Notification("El beneficio en la jerarquía se ha eliminado correctamente.");
    }

    public static Notification FetchHierarchyBenefitSuccess() {
        return new Notification("Lista de beneficios de la jerarquía.");
    }

    public static Notification FetchHierarchyBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los beneficios de la jerarquía.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
