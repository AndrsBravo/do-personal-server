package com.personal.business.employeededuction.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeDeductionNotificationFactory {

    public static Notification CreateEmployeeDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la deducción de empleado ");
    }

    public static Notification CreateEmployeeDeductionSuccess() {
        return new Notification("La deducción de empleado se ha creado correctamente ");
    }

    public static Notification UpdateEmployeeDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la deducción de empleado ");
    }

    public static Notification UpdateEmployeeDeductionSuccess() {
        return new Notification("La deducción de empleado se ha actualizado correctamente ");
    }

    public static Notification DeleteEmployeeDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la deducción de empleado ");
    }

    public static Notification DeleteEmployeeDeductionSuccess() {
        return new Notification("La deducción de empleado se ha eliminado correctamente ");
    }

    public static Notification FetchEmployeeDeductionSuccess() {
        return new Notification("Lista de deducciones de empleados.");
    }

    public static Notification FetchEmployeeDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las deducciones de empleados.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
