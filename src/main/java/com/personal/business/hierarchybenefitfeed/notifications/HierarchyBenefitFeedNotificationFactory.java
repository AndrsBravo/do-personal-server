package com.personal.business.hierarchybenefitfeed.notifications;

import com.personal.shared.notifications.Notification;

public class HierarchyBenefitFeedNotificationFactory {

    public static Notification CreateHierarchyBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateHierarchyBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteHierarchyBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
