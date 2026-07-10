package com.personal.business.deductioncategory.factories;

import java.util.List;

import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.business.deductioncategory.notifications.DeductionCategoryNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class DeductionCategoryResultFactory {

    public static ServiceResult<DeductionCategory> CreateFail() {
        return new ServiceResult<>(DeductionCategoryNotificationFactory.CreateDeductionCategoryFail(), null);
    }

    public static ServiceResult<DeductionCategory> CreateSuccess(DeductionCategory deductionCategory) {
        return new ServiceResult<>(null, deductionCategory);
    }

    public static ServiceResult<DeductionCategory> UpdateFail() {
        return new ServiceResult<>(DeductionCategoryNotificationFactory.UpdateDeductionCategoryFail(), null);
    }

    public static ServiceResult<DeductionCategory> UpdateSuccess(DeductionCategory deductionCategory) {
        return new ServiceResult<>(null, deductionCategory);
    }

    public static ServiceResult<DeductionCategory> DeleteSuccess(DeductionCategory deductionCategory) {
        return new ServiceResult<>(null, deductionCategory);
    }

    public static ServiceResult<DeductionCategory> DeleteFail() {
        return new ServiceResult<>(DeductionCategoryNotificationFactory.DeleteDeductionCategoryFail(), null);
    }

    public static ServiceResult<List<DeductionCategory>> FetchNull() {
        return new ServiceResult<>(DeductionCategoryNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<DeductionCategory>> FetchResult(List<DeductionCategory> deductionCategory) {
        return new ServiceResult<>(null, deductionCategory);
    }

}
