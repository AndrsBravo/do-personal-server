package com.personal.business.employeebenefit.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeBenefitNotificationFactory {

    public static Notification CreateEmployeeBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateEmployeeBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteEmployeeBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
