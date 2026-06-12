package com.personal.business.hierarchybenefit.notifications;

import com.personal.shared.notifications.Notification;

public class HierarchyBenefitNotificationFactory {

    public static Notification CreateHierarchyBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateHierarchyBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteHierarchyBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
