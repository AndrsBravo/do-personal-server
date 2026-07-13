package com.personal.business.employee.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeNotificationFactory {

    public static Notification CreateEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el empleado ");
    }

    public static Notification CreateEmployeeSuccess() {
        return new Notification("El empleado se ha creado correctamente ");
    }

    public static Notification UpdateEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el empleado ");
    }

    public static Notification UpdateEmployeeSuccess() {
        return new Notification("El empleado se ha actualizado correctamente.");
    }

    public static Notification DeleteEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el empleado ");
    }

    public static Notification DeleteEmployeeSuccess() {
        return new Notification("El empleado se ha eliminado correctamente.");
    }

    public static Notification FetchEmployeeSuccess() {
        return new Notification("Lista de empleados.");
    }

    public static Notification FetchEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los empleados.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
