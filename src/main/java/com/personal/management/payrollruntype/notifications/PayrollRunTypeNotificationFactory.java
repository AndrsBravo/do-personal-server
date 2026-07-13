package com.personal.management.payrollruntype.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollRunTypeNotificationFactory {

    public static Notification CreatePayrollRunTypeFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de calculo de nomina ");
    }

    public static Notification CreatePayrollRunTypeSuccess() {
        return new Notification("El tipo de calculo de nomina se ha creado correctamente.");
    }

    public static Notification UpdatePayrollRunTypeFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de calculo de nomina ");
    }

    public static Notification UpdatePayrollRunTypeSuccess() {
        return new Notification("El tipo de calculo de nomina se ha actualizado correctamente.");
    }

    public static Notification DeletePayrollRunTypeFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de calculo de nomina ");
    }

    public static Notification DeletePayrollRunTypeSuccess() {
        return new Notification("El tipo de calculo de nomina ha sido eliminada exitosamente. ");
    }

    public static Notification FetchPayrollRunTypeSuccess() {
        return new Notification("Lista de tipos de calculo de nomina.");
    }

    public static Notification FetchPayrollRunTypeFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los tipos de calculo de nomina.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
