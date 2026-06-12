package com.personal.management.payrollrundeduction.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollRunDeductionNotificationFactory {

    public static Notification CreatePayrollRunDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdatePayrollRunDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeletePayrollRunDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
