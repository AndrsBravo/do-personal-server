package com.personal.business.payrollbenefit.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollBenefitNotificationFactory {

    public static Notification CreatePayrollBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdatePayrollBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeletePayrollBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
