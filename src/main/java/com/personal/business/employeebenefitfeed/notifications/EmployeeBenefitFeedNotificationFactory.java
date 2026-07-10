package com.personal.business.employeebenefitfeed.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeBenefitFeedNotificationFactory {

    public static Notification CreateEmployeeBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el valor de beneficio de empleado ");
    }

    public static Notification CreateEmployeeBenefitFeedSuccess() {
        return new Notification("El valor de beneficio de empleado se ha creado correctamente ");
    }

    public static Notification UpdateEmployeeBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el valor de beneficio de empleado ");
    }

    public static Notification UpdateEmployeeBenefitFeedSuccess() {
        return new Notification("El valor de beneficio de empleado se ha actualizado correctamente.");
    }

    public static Notification DeleteEmployeeBenefitFeedFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el valor de beneficio de empleado ");
    }

    public static Notification DeleteEmployeeBenefitFeedSuccess() {
        return new Notification("El valor de beneficio de empleado se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
