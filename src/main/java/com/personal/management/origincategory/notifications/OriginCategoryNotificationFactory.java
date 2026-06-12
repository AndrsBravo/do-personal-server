package com.personal.management.origincategory.notifications;

import com.personal.shared.notifications.Notification;

public class OriginCategoryNotificationFactory {

    public static Notification CreateOriginCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateOriginCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteOriginCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
