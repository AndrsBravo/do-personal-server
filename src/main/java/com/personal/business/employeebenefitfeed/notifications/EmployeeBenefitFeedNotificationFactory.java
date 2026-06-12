package com.personal.business.employeebenefitfeed.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeBenefitFeedNotificationFactory {

    public static Notification CreateEmployeeBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateEmployeeBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteEmployeeBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
