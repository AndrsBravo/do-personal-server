package com.personal.management.deductionrate.notifications;

import com.personal.shared.notifications.Notification;

public class DeductionRateNotificationFactory {

    public static Notification CreateDeductionRateFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el valor de deducción ");
    }

    public static Notification CreateDeductionRateSuccess() {
        return new Notification("El valor de deducción se ha creado correctamente.");
    }

    public static Notification UpdateDeductionRateFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el valor de deducción ");
    }

    public static Notification UpdateDeductionRateSuccess() {
        return new Notification("El valor de deducción se ha actualizado correctamente.");
    }

    public static Notification DeleteDeductionRateFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el valor de deducción ");
    }

    public static Notification DeleteDeductionRateSuccess() {
        return new Notification("El valor de deducción se ha eliminado correctamente.");
    }

    public static Notification FetchDeductionRateSuccess() {
        return new Notification("Lista de valores de deducciones.");
    }

    public static Notification FetchDeductionRateFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los valores de las deducciones.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
