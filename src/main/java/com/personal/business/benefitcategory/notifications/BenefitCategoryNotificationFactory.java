package com.personal.business.benefitcategory.notifications;

import com.personal.shared.notifications.Notification;

public class BenefitCategoryNotificationFactory {

    public static Notification CreateBenefitCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateBenefitCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteBenefitCategoryFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
