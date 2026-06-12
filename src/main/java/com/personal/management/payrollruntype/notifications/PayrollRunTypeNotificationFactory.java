package com.personal.management.payrollruntype.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollRunTypeNotificationFactory {

    public static Notification CreatePayrollRunTypeFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de cliente ");
    }

    public static Notification UpdatePayrollRunTypeFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de cliente ");
    }

    public static Notification DeletePayrollRunTypeFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de cliente ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
