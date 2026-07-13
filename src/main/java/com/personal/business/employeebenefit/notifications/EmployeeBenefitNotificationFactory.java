package com.personal.business.employeebenefit.notifications;

import com.personal.shared.notifications.Notification;

public class EmployeeBenefitNotificationFactory {

    public static Notification CreateEmployeeBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el beneficio de empleado ");
    }

    public static Notification CreateEmployeeBenefitSuccess() {
        return new Notification("El beneficio de empleado se ha creado correctamente ");
    }

    public static Notification UpdateEmployeeBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el beneficio de empleado ");
    }

    public static Notification UpdateEmployeeBenefitSuccess() {
        return new Notification("El beneficio de empleado se ha actualizado correctamente.");
    }

    public static Notification DeleteEmployeeBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el beneficio de empleado ");
    }

    public static Notification DeleteEmployeeBenefitSuccess() {
        return new Notification("El beneficio de empleado se ha eliminado correctamente.");
    }

    public static Notification FetchEmployeeBenefitSuccess() {
        return new Notification("Lista de beneficios de empleados.");
    }

    public static Notification FetchEmployeeBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los beneficios de empleados.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
