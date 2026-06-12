package com.personal.business.payrollrunbenefit.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollRunBenefitNotificationFactory {

    public static Notification CreatePayrollRunBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdatePayrollRunBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeletePayrollRunBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
