package com.personal.management.benefitrate.factories;

import java.util.List;

import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.management.benefitrate.notifications.BenefitRateNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class BenefitRateResultFactory {

    public static ServiceResult<BenefitRate> CreateFail() {
        return new ServiceResult<>(BenefitRateNotificationFactory.CreateBenefitRateFail(), null);
    }

    public static ServiceResult<BenefitRate> CreateSuccess(BenefitRate benefit) {
        return new ServiceResult<>(null, benefit);
    }

    public static ServiceResult<BenefitRate> UpdateFail() {
        return new ServiceResult<>(BenefitRateNotificationFactory.UpdateBenefitRateFail(), null);
    }

    public static ServiceResult<BenefitRate> UpdateSuccess(BenefitRate benefit) {
        return new ServiceResult<>(null, benefit);
    }

    public static ServiceResult<BenefitRate> DeleteSuccess(BenefitRate benefit) {
        return new ServiceResult<>(null, benefit);
    }

    public static ServiceResult<BenefitRate> DeleteFail() {
        return new ServiceResult<>(BenefitRateNotificationFactory.DeleteBenefitRateFail(), null);
    }

    public static ServiceResult<List<BenefitRate>> FetchNull() {
        return new ServiceResult<>(BenefitRateNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<BenefitRate>> FetchResult(List<BenefitRate> benefit) {
        return new ServiceResult<>(null, benefit);
    }

}
