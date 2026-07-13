package com.personal.business.payrolldeduction.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollDeductionNotificationFactory {

    public static Notification CreatePayrollDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la deducción de nomina ");
    }

    public static Notification CreatePayrollDeductionSuccess() {
        return new Notification("La deducción de nomina se ha creado correctamente.");
    }

    public static Notification UpdatePayrollDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la deducción de nomina ");
    }

    public static Notification UpdatePayrollDeductionSuccess() {
        return new Notification("La deducción de nomina se ha actualizado correctamente.");
    }

    public static Notification DeletePayrollDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la deducción de nomina ");
    }

    public static Notification DeletePayrollDeductionSuccess() {
        return new Notification("La deducción de nomina se ha eliminado correctamente.");
    }

    public static Notification FetchPayrollDeductionSuccess() {
        return new Notification("Lista de deducciones de nomina.");
    }

    public static Notification FetchPayrollDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las deducciones de nomina.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
