package com.personal.business.benefitdeductionrelation.notifications;

import com.personal.shared.notifications.Notification;

public class BenefitDeductionRelationNotificationFactory {

    public static Notification CreateBenefitDeductionRelationFail() {
        return new Notification("Ha ocurrido un error mientras se creaba el tipo de usuario ");
    }

    public static Notification UpdateBenefitDeductionRelationFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba el tipo de usuario ");
    }

    public static Notification DeleteBenefitDeductionRelationFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba el tipo de usuario ");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado tipos de usuario.");
    }

}
