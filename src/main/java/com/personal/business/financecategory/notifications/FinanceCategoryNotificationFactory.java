package com.personal.business.financecategory.notifications;

import com.personal.shared.notifications.Notification;

public class FinanceCategoryNotificationFactory {

    public static Notification CreateFinanceCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateFinanceCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteFinanceCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
