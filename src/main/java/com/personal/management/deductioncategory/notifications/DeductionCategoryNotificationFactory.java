package com.personal.management.deductioncategory.notifications;

import com.personal.shared.notifications.Notification;

public class DeductionCategoryNotificationFactory {

    public static Notification CreateDeductionCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la categoría deducción ");
    }

    public static Notification CreateDeductionCategorySuccess() {
        return new Notification("La categoría deducción se ha creado correctamente.");
    }

    public static Notification UpdateDeductionCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la categoría deducción ");
    }

    public static Notification UpdateDeductionCategorySuccess() {
        return new Notification("La categoría deducción se ha actualizado correctamente.");
    }

    public static Notification DeleteDeductionCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la categoría deducción ");
    }

    public static Notification DeleteDeductionCategorySuccess() {
        return new Notification("La categoría deducción se ha eliminado correctamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
