package com.personal.business.origincategory.notifications;

import com.personal.shared.notifications.Notification;

public class OriginCategoryNotificationFactory {

    public static Notification CreateOriginCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el origen de la categoría ");
    }

    public static Notification CreateOriginCategorySuccess() {
        return new Notification("El origen de la categoría se ha creado correctamente.");
    }

    public static Notification UpdateOriginCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el origen de la categoría ");
    }

    public static Notification UpdateOriginCategorySuccess() {
        return new Notification("El origen de la categoría se ha actualizado correctamente.");
    }

    public static Notification DeleteOriginCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el origen de la categoría ");
    }

    public static Notification DeleteOriginCategorySuccess() {
        return new Notification("El origen de la categoría se ha eliminado correctamente.");
    }

    public static Notification FetchOriginCategorySuccess() {
        return new Notification("Lista de categorías de origen.");
    }

    public static Notification FetchOriginCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las categorías de origen.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
