package com.personal.business.hierarchydeductionfeed.notifications;

import com.personal.shared.notifications.Notification;

public class HierarchyDeductionFeedNotificationFactory {

    public static Notification CreateHierarchyDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateHierarchyDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteHierarchyDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
