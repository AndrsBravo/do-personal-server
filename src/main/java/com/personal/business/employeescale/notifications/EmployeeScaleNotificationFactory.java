package com.personal.business.employeescale.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeScaleNotificationFactory {

    public static Notification CreateEmployeeScaleFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateEmployeeScaleFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteEmployeeScaleFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
