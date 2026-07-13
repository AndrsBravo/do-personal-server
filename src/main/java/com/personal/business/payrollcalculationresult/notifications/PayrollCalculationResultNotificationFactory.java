package com.personal.business.payrollcalculationresult.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollCalculationResultNotificationFactory {

    public static Notification CreatePayrollCalculationResultFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el resultado del calculo de nomina ");
    }

    public static Notification CreatePayrollCalculationResultSuccess() {
        return new Notification("El resultado del calculo de nomina se ha creado correctamente.");
    }

    public static Notification UpdatePayrollCalculationResultFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el resultado del calculo de nomina ");
    }

    public static Notification UpdatePayrollCalculationResultSuccess() {
        return new Notification("El resultado del calculo de nomina se ha actualizado correctamente.");
    }

    public static Notification DeletePayrollCalculationResultFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el resultado del calculo de nomina ");
    }

    public static Notification DeletePayrollCalculationResultSuccess() {
        return new Notification("El resultado del calculo de nomina se ha eliminado correctamente.");
    }

    public static Notification FetchPayrollCalculationResultSuccess() {
        return new Notification("Lista de resultados de cálculos de nomina.");
    }

    public static Notification FetchPayrollCalculationResultFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los resultados de cálculos de nomina.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
