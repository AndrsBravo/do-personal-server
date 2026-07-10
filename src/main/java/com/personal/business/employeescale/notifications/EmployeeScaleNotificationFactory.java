package com.personal.business.employeescale.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeScaleNotificationFactory {

    public static Notification CreateEmployeeScaleFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la escala de empleado ");
    }

    public static Notification CreateEmployeeScaleSuccess() {
        return new Notification("La escala de empleado se ha creado correctamente.");
    }

    public static Notification UpdateEmployeeScaleFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la escala de empleado ");
    }

    public static Notification UpdateEmployeeScaleSuccess() {
        return new Notification("La escala de empleado se ha actualizado correctamente.");
    }

    public static Notification DeleteEmployeeScaleFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la escala de empleado ");
    }

    public static Notification DeleteEmployeeScaleSuccess() {
        return new Notification("La escala de empleado se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
