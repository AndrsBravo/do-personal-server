package com.personal.management.deductionrate.factories;

import java.util.List;

import com.personal.management.deductionrate.entities.DeductionRate;
import com.personal.management.deductionrate.notifications.DeductionRateNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class DeductionRateResultFactory {

    public static ServiceResult<DeductionRate> CreateFail() {
        return new ServiceResult<>(DeductionRateNotificationFactory.CreateDeductionRateFail(), null);
    }

    public static ServiceResult<DeductionRate> CreateSuccess(DeductionRate deduction) {
        return new ServiceResult<>(null, deduction);
    }

    public static ServiceResult<DeductionRate> UpdateFail() {
        return new ServiceResult<>(DeductionRateNotificationFactory.UpdateDeductionRateFail(), null);
    }

    public static ServiceResult<DeductionRate> UpdateSuccess(DeductionRate deduction) {
        return new ServiceResult<>(null, deduction);
    }

    public static ServiceResult<DeductionRate> DeleteSuccess(DeductionRate deduction) {
        return new ServiceResult<>(null, deduction);
    }

    public static ServiceResult<DeductionRate> DeleteFail() {
        return new ServiceResult<>(DeductionRateNotificationFactory.DeleteDeductionRateFail(), null);
    }

    public static ServiceResult<List<DeductionRate>> FetchNull() {
        return new ServiceResult<>(DeductionRateNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<DeductionRate>> FetchResult(List<DeductionRate> deduction) {
        return new ServiceResult<>(null, deduction);
    }

}
