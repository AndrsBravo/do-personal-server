package com.personal.backoffice.business.notifications;

import com.personal.shared.notifications.Notification;

public class BusinessNotificationFactory {

    public static Notification CreateBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la empresa ");
    }

    public static Notification CreateBusinessSuccess() {
        return new Notification("La empresa ha sido creada correctamente.");
    }

    public static Notification UpdateBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la empresa ");
    }

    public static Notification UpdateBusinessSuccess() {
        return new Notification("La empresa ha sido actualizada correctamente.");
    }

    public static Notification DeleteBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la empresa ");
    }

    public static Notification DeleteBusinessSuccess() {
        return new Notification("La empresa se ha eliminado correctamente ");
    }

    public static Notification FetchBusinessSuccess() {
        return new Notification("Lista de empresas.");
    }

    public static Notification FetchBusinessFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban las empresas.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
