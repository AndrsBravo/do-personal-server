package com.personal.business.payrollcalculationresult.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollCalculationResultNotificationFactory {

    public static Notification CreatePayrollCalculationResultFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdatePayrollCalculationResultFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeletePayrollCalculationResultFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
