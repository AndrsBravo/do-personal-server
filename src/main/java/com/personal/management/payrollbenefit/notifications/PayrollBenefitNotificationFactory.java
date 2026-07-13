package com.personal.management.payrollbenefit.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollBenefitNotificationFactory {

    public static Notification CreatePayrollBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el beneficio nomina ");
    }

    public static Notification CreatePayrollBenefitSuccess() {
        return new Notification("El beneficio nomina se ha creado correctamente.");
    }

    public static Notification UpdatePayrollBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el beneficio nomina ");
    }

    public static Notification UpdatePayrollBenefitSuccess() {
        return new Notification("El beneficio nomina se ha actualizado correctamente.");
    }

    public static Notification DeletePayrollBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el beneficio nomina ");
    }

    public static Notification DeletePayrollBenefitSuccess() {
        return new Notification("El beneficio nomina se ha eliminado correctamente.");
    }

    public static Notification FetchPayrollBenefitSuccess() {
        return new Notification("Lista de beneficios de nomina.");
    }

    public static Notification FetchPayrollBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los beneficios de nomina.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
