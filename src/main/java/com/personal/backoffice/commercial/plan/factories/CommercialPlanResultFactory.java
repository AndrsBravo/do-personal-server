package com.personal.backoffice.commercial.plan.factories;

import java.util.List;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plan.notifications.CommercialPlanNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class CommercialPlanResultFactory {

    public static ServiceResult<CommercialPlan> CreateFail() {
        return new ServiceResult<>(CommercialPlanNotificationFactory.CreateCommercialPlanFail(), null);
    }

    public static ServiceResult<CommercialPlan> CreateSuccess(CommercialPlan commercialPlan) {
        return new ServiceResult<>(null, commercialPlan);
    }

    public static ServiceResult<CommercialPlan> UpdateFail() {
        return new ServiceResult<>(CommercialPlanNotificationFactory.UpdateCommercialPlanFail(), null);
    }

    public static ServiceResult<CommercialPlan> UpdateSuccess(CommercialPlan commercialPlan) {
        return new ServiceResult<>(null, commercialPlan);
    }

    public static ServiceResult<CommercialPlan> DeleteSuccess(CommercialPlan commercialPlan) {
        return new ServiceResult<>(null, commercialPlan);
    }

    public static ServiceResult<CommercialPlan> DeleteFail() {
        return new ServiceResult<>(CommercialPlanNotificationFactory.DeleteCommercialPlanFail(), null);
    }

    public static ServiceResult<List<CommercialPlan>> FetchNull() {
        return new ServiceResult<>(CommercialPlanNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<CommercialPlan>> FetchResult(List<CommercialPlan> commercialPlan) {
        return new ServiceResult<>(null, commercialPlan);
    }

}
