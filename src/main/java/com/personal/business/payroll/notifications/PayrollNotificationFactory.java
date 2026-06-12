package com.personal.business.payroll.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollNotificationFactory {

    public static Notification CreatePayrollFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdatePayrollFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeletePayrollFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
