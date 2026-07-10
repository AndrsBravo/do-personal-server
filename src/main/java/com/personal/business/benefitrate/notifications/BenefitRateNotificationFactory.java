package com.personal.business.benefitrate.notifications;

import com.personal.shared.notifications.Notification;

public class BenefitRateNotificationFactory {

    public static Notification CreateBenefitRateFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el valor de beneficio ");
    }

    public static Notification CreateBenefitRateSuccess() {
        return new Notification("El valor de beneficio se ha creado exitosamente.");
    }

    public static Notification UpdateBenefitRateFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el valor de beneficio ");
    }

    public static Notification UpdateBenefitRateSuccess() {
        return new Notification("El valor de beneficio se ha actualizado exitosamente.");
    }

    public static Notification DeleteBenefitRateFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el valor de beneficio ");
    }

    public static Notification DeleteBenefitRateSuccess() {
        return new Notification("El valor de beneficio se ha eliminado exitosamente.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
