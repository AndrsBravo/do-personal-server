package com.personal.management.benefit.factories;

import java.util.List;

import com.personal.management.benefit.entities.Benefit;
import com.personal.management.benefit.notifications.BenefitNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class BenefitResultFactory {

    public static ServiceResult<Benefit> CreateFail() {
        return new ServiceResult<>(BenefitNotificationFactory.CreateBenefitFail(), null);
    }

    public static ServiceResult<Benefit> CreateSuccess(Benefit benefit) {
        return new ServiceResult<>(null, benefit);
    }

    public static ServiceResult<Benefit> UpdateFail() {
        return new ServiceResult<>(BenefitNotificationFactory.UpdateBenefitFail(), null);
    }

    public static ServiceResult<Benefit> UpdateSuccess(Benefit benefit) {
        return new ServiceResult<>(null, benefit);
    }

    public static ServiceResult<Benefit> DeleteSuccess(Benefit benefit) {
        return new ServiceResult<>(null, benefit);
    }

    public static ServiceResult<Benefit> DeleteFail() {
        return new ServiceResult<>(BenefitNotificationFactory.DeleteBenefitFail(), null);
    }

    public static ServiceResult<List<Benefit>> FetchNull() {
        return new ServiceResult<>(BenefitNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Benefit>> FetchResult(List<Benefit> benefit) {
        return new ServiceResult<>(null, benefit);
    }

}
