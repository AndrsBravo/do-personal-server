package com.personal.management.deduction.notifications;

import com.personal.shared.notifications.Notification;

public class DeductionNotificationFactory {

    public static Notification CreateDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la deducción ");
    }

    public static Notification CreateDeductionSuccess() {
        return new Notification("La deducción se ha creado correctamente.");
    }

    public static Notification UpdateDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la deducción ");
    }

    public static Notification UpdateDeductionSuccess() {
        return new Notification("La deducción se ha actualizado correctamente.");
    }

    public static Notification DeleteDeductionFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la deducción ");
    }

    public static Notification DeleteDeductionSuccess() {
        return new Notification("La deducción se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
