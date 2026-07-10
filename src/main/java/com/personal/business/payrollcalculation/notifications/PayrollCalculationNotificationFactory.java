package com.personal.business.payrollcalculation.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollCalculationNotificationFactory {

    public static Notification CreatePayrollCalculationFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el calculo de nomina ");
    }

    public static Notification CreatePayrollCalculationSuccess() {
        return new Notification("El calculo de nomina se ha creado correctamente.");
    }

    public static Notification UpdatePayrollCalculationFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el calculo de nomina ");
    }

    public static Notification UpdatePayrollCalculationSuccess() {
        return new Notification("El calculo de nomina se ha actualizado correctamente.");
    }

    public static Notification DeletePayrollCalculationFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el calculo de nomina ");
    }

    public static Notification DeletePayrollCalculationSuccess() {
        return new Notification("El calculo de nomina se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
