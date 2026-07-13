package com.personal.business.payrollemployee.notifications;

import com.personal.shared.notifications.Notification;

public class PayrollEmployeeNotificationFactory {

    public static Notification CreatePayrollEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el empleado en la nomina ");
    }

    public static Notification CreatePayrollEmployeeSuccess() {
        return new Notification("Se ha adicionado el empleado en la nomina exitosamente.");
    }

    public static Notification UpdatePayrollEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el empleado en la nomina ");
    }

    public static Notification UpdatePayrollEmployeeSuccess() {
        return new Notification("El empleado se ha actualizado en la nomina exitosamente.");
    }

    public static Notification DeletePayrollEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el empleado en la nomina ");
    }

    public static Notification DeletePayrollEmployeeSuccess() {
        return new Notification("El empleado se ha eliminado de la nomina exitosamente.");
    }

    public static Notification FetchPayrollEmployeeSuccess() {
        return new Notification("Lista de empleados de nomina.");
    }

    public static Notification FetchPayrollEmployeeFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los empleados de la nomina.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
