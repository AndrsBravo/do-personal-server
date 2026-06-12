package com.personal.business.employeedeductionfeed.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeDeductionFeedNotificationFactory {

    public static Notification CreateEmployeeDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateEmployeeDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteEmployeeDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
