package com.personal.business.benefit.notifications;

import com.personal.shared.notifications.Notification;

public class BenefitNotificationFactory {

    public static Notification CreateBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el beneficio ");
    }

    public static Notification CreateBenefitSuccess() {
        return new Notification("El beneficio ha sido creado satisfactoriamente. ");
    }

    public static Notification UpdateBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el beneficio ");
    }

    public static Notification UpdateBenefitSuccess() {
        return new Notification("El beneficio ha sido actualizado satisfactoriamente. ");
    }

    public static Notification DeleteBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el beneficio ");
    }

    public static Notification DeleteBenefitSuccess() {
        return new Notification("El beneficio ha sido eliminado satisfactoriamente. ");
    }

    public static Notification FetchBenefitSuccess() {
        return new Notification("Lista de beneficios.");
    }

    public static Notification FetchBenefitFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los beneficios.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
