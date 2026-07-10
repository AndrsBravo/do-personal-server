package com.personal.backoffice.commercial.plandetail.factories;

import java.util.List;

import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.backoffice.commercial.plandetail.notifications.CommercialPlanDetailNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class CommercialPlanDetailResultFactory {

    public static ServiceResult<CommercialPlanDetail> CreateFail() {
        return new ServiceResult<>(CommercialPlanDetailNotificationFactory.CreateCommercialPlanDetailFail(), null);
    }

    public static ServiceResult<CommercialPlanDetail> CreateSuccess(CommercialPlanDetail commercialPlan) {
        return new ServiceResult<>(null, commercialPlan);
    }

    public static ServiceResult<CommercialPlanDetail> UpdateFail() {
        return new ServiceResult<>(CommercialPlanDetailNotificationFactory.UpdateCommercialPlanDetailFail(), null);
    }

    public static ServiceResult<CommercialPlanDetail> UpdateSuccess(CommercialPlanDetail commercialPlan) {
        return new ServiceResult<>(null, commercialPlan);
    }

    public static ServiceResult<CommercialPlanDetail> DeleteSuccess(CommercialPlanDetail commercialPlan) {
        return new ServiceResult<>(null, commercialPlan);
    }

    public static ServiceResult<CommercialPlanDetail> DeleteFail() {
        return new ServiceResult<>(CommercialPlanDetailNotificationFactory.DeleteCommercialPlanDetailFail(), null);
    }

    public static ServiceResult<List<CommercialPlanDetail>> FetchNull() {
        return new ServiceResult<>(CommercialPlanDetailNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<CommercialPlanDetail>> FetchResult(List<CommercialPlanDetail> commercialPlan) {
        return new ServiceResult<>(null, commercialPlan);
    }

}
