package com.personal.business.payroll.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollNotificationFactory {

    public static Notification CreatePayrollFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la nomina ");
    }

    public static Notification CreatePayrollSuccess() {
        return new Notification("La nomina se ha creado correctamente.");
    }

    public static Notification UpdatePayrollFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la nomina ");
    }

    public static Notification UpdatePayrollSuccess() {
        return new Notification("La nomina se ha actualizado correctamente.");
    }

    public static Notification DeletePayrollFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la nomina ");
    }

    public static Notification DeletePayrollSuccess() {
        return new Notification("La nomina se ha eliminado correctamente.");
    }

    public static Notification FetchPayrollSuccess() {
        return new Notification("Lista de nominas.");
    }

    public static Notification FetchPayrollFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las nominas.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
