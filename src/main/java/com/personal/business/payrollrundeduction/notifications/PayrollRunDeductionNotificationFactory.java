package com.personal.business.payrollrundeduction.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollRunDeductionNotificationFactory {

    public static Notification CreatePayrollRunDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el deducción para calculo de nomina ");
    }

    public static Notification CreatePayrollRunDeductionSuccess() {
        return new Notification("La deducción para calculo de nomina se ha creado correctamente.");
    }

    public static Notification UpdatePayrollRunDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el deducción para calculo de nomina ");
    }

    public static Notification UpdatePayrollRunDeductionSuccess() {
        return new Notification("El deducción para calculo de nomina se ha actualizado correctamente.");
    }

    public static Notification DeletePayrollRunDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el deducción para calculo de nomina ");
    }

    public static Notification DeletePayrollRunDeductionSuccess() {
        return new Notification("El deducción para calculo de nomina se ha eliminado correctamente.");
    }

    public static Notification FetchPayrollRunDeductionSuccess() {
        return new Notification("Lista de deducciones en calculo de nomina.");
    }

    public static Notification FetchPayrollRunDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las deducciones en calculo de nomina.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
