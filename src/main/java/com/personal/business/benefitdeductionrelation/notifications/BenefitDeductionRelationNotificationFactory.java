package com.personal.business.benefitdeductionrelation.notifications;

import com.personal.shared.notifications.Notification;

public class BenefitDeductionRelationNotificationFactory {

    public static Notification CreateBenefitDeductionRelationFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la relación deducción beneficio ");
    }

    public static Notification CreateBenefitDeductionRelationSuccess() {
        return new Notification("La relación deducción beneficio se ha creado correctamente ");
    }

    public static Notification UpdateBenefitDeductionRelationFail() {
        return new Notification("Ha ocurrido un error mientras se actualizaba la relación deducción beneficio ");
    }

    public static Notification UpdateBenefitDeductionRelationSuccess() {
        return new Notification("La relación deducción beneficio se ha actualizado correctamente ");
    }

    public static Notification DeleteBenefitDeductionRelationFail() {
        return new Notification("Ha ocurrido un error mientras se eliminaba la relación deducción beneficio ");
    }

    public static Notification DeleteBenefitDeductionRelationSuccess() {
        return new Notification("La relación deducción beneficio se ha eliminado correctamente ");
    }

    public static Notification FetchBenefitDeductionRelationSuccess() {
        return new Notification("Lista de beneficios y deducciones relacionados.");
    }

    public static Notification FetchBenefitDeductionRelationFail() {
        return new Notification("Ha ocurrido un error mientras se consultaban los beneficios y deducciones relacionados.");
    }

    public static Notification FetchNull() {
        return new Notification("No se han encontrado resultados.");
    }

}
