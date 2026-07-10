package com.personal.business.payrollrunbenefit.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollRunBenefitNotificationFactory {

    public static Notification CreatePayrollRunBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el beneficio para calculo de nomina ");
    }

    public static Notification CreatePayrollRunBenefitSuccess() {
        return new Notification("Se ha creado el beneficio para calculo de nomina exitosamente.");
    }

    public static Notification UpdatePayrollRunBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el beneficio para calculo de nomina ");
    }

    public static Notification UpdatePayrollRunBenefitSuccess() {
        return new Notification("El beneficio para calculo de nomina se ha actualizado exitosamente.");
    }

    public static Notification DeletePayrollRunBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el beneficio para calculo de nomina ");
    }

    public static Notification DeletePayrollRunBenefitSuccess() {
        return new Notification("El beneficio para calculo de nomina se ha eliminado exitosamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
