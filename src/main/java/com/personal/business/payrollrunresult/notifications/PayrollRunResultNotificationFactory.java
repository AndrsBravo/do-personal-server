package com.personal.business.payrollrunresult.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollRunResultNotificationFactory {

    public static Notification CreatePayrollRunResultFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el resultado del calculo de nomina ");
    }

    public static Notification CreatePayrollRunResultSuccess() {
        return new Notification("El resultado del calculo de nomina se ha creado correctamente.");
    }

    public static Notification UpdatePayrollRunResultFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el resultado del calculo de nomina ");
    }

    public static Notification UpdatePayrollRunResultSuccess() {
        return new Notification("El resultado del calculo de nomina se ha actualizado correctamente.");
    }

    public static Notification DeletePayrollRunResultFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el resultado del calculo de nomina ");
    }

    public static Notification DeletePayrollRunResultSuccess() {
        return new Notification("El resultado del calculo de nomina se ha eliminado correctamente.");
    }

    public static Notification FetchPayrollRunResultSuccess() {
        return new Notification("Lista de resultados de cálculos de nomina.");
    }

    public static Notification FetchPayrollRunResultFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los resultados de calculo de nomina.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
