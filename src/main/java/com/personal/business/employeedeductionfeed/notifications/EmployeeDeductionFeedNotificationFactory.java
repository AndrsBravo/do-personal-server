package com.personal.business.employeedeductionfeed.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeDeductionFeedNotificationFactory {

    public static Notification CreateEmployeeDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el valor la deducción de empleado ");
    }

    public static Notification CreateEmployeeDeductionFeedSuccess() {
        return new Notification("El valor de la deducción de empleado se ha creado correctamente.");
    }

    public static Notification UpdateEmployeeDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el valor la deducción de empleado ");
    }

    public static Notification UpdateEmployeeDeductionFeedSuccess() {
        return new Notification("El valor de la deducción de empleado se ha actualizado correctamente.");
    }

    public static Notification DeleteEmployeeDeductionFeedFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el valor la deducción de empleado ");
    }

    public static Notification DeleteEmployeeDeductionFeedSuccess() {
        return new Notification("El valor de la deducción de empleado se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
