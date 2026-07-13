package com.personal.business.structure.notifications;

import com.personal.shared.notifications.Notification;

public class StructureNotificationFactory {

    public static Notification CreateStructureFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la estructura organizacional ");
    }

    public static Notification CreateStructureSuccess() {
        return new Notification("La estructura organizacional se ha creado correctamente.");
    }

    public static Notification UpdateStructureFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la estructura organizacional ");
    }

    public static Notification UpdateStructureSuccess() {
        return new Notification("La estructura organizacional se ha actualizado correctamente.");
    }

    public static Notification DeleteStructureFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la estructura organizacional ");
    }

    public static Notification DeleteStructureSuccess() {
        return new Notification("La estructura organizacional se ha eliminado correctamente.");
    }

    public static Notification FetchStructureSuccess() {
        return new Notification("Lista de estructuras.");
    }

    public static Notification FetchStructureFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las estructuras.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
