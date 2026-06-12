package com.personal.business.employeededuction.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeDeductionNotificationFactory {

    public static Notification CreateEmployeeDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateEmployeeDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteEmployeeDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
