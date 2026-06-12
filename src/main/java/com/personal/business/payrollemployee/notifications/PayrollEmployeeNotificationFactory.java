package com.personal.business.payrollemployee.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollEmployeeNotificationFactory {

    public static Notification CreatePayrollEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdatePayrollEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeletePayrollEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
