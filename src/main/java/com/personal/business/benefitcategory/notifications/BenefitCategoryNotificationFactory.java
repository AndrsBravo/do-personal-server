package com.personal.business.benefitcategory.notifications;

import com.personal.shared.notifications.Notification;

public class BenefitCategoryNotificationFactory {

    public static Notification CreateBenefitCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la categoría de beneficio ");
    }

    public static Notification CreateBenefitCategorySuccess() {
        return new Notification("La categoría de beneficio se ha creado correctamente ");
    }

    public static Notification UpdateBenefitCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la categoría de beneficio ");
    }

    public static Notification UpdateBenefitCategorySuccess() {
        return new Notification("La categoría de beneficio se ha actualizado correctamente ");
    }

    public static Notification DeleteBenefitCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la categoría de beneficio ");
    }

    public static Notification DeleteBenefitCategorySuccess() {
        return new Notification("La categoría de beneficio se ha eliminado correctamente ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
