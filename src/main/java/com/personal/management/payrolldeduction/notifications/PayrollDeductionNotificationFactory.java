package com.personal.management.payrolldeduction.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollDeductionNotificationFactory {

    public static Notification CreatePayrollDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdatePayrollDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeletePayrollDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
