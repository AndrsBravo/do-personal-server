package com.personal.business.financecategory.notifications;

import com.personal.shared.notifications.Notification;

public class FinanceCategoryNotificationFactory {

    public static Notification CreateFinanceCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la categoría financiera ");
    }

    public static Notification CreateFinanceCategorySuccess() {
        return new Notification("La categoría financiera se ha creado correctamente.");
    }

    public static Notification UpdateFinanceCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la categoría financiera ");
    }

    public static Notification UpdateFinanceCategorySuccess() {
        return new Notification("La categoría financiera se ha actualizado correctamente.");
    }

    public static Notification DeleteFinanceCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la categoría financiera ");
    }

    public static Notification DeleteFinanceCategorySuccess() {
        return new Notification("La categoría financiera se ha eliminado correctamente.");
    }

    public static Notification FetchFinanceCategorySuccess() {
        return new Notification("Lista de categorías financieras.");
    }

    public static Notification FetchFinanceCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las categorías financieras.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
