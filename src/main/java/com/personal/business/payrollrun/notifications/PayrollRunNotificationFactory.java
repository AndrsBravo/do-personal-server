package com.personal.business.payrollrun.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollRunNotificationFactory {

    public static Notification CreatePayrollRunFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el calculo nomina ");
    }

    public static Notification CreatePayrollRunSuccess() {
        return new Notification("Se ha realizado el calculo nomina exitosamente.");
    }

    public static Notification UpdatePayrollRunFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el calculo nomina ");
    }

    public static Notification UpdatePayrollRunSuccess() {
        return new Notification("El calculo nomina se ha actualizado exitosamente.");
    }

    public static Notification DeletePayrollRunFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el calculo nomina ");
    }

    public static Notification DeletePayrollRunSuccess() {
        return new Notification("El calculo nomina se ha eliminado exitosamente.");
    }

    public static Notification FetchPayrollRunSuccess() {
        return new Notification("Lista de calculo de nomina.");
    }

    public static Notification FetchPayrollRunFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los cálculos de nomina.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
