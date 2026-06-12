package com.personal.business.benefitcategory.factories;

import java.util.List;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.business.benefitcategory.notifications.BenefitCategoryNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class BenefitCategoryResultFactory {

    public static ServiceResult<BenefitCategory> CreateFail() {
        return new ServiceResult<>(BenefitCategoryNotificationFactory.CreateBenefitCategoryFail(), null);
    }

    public static ServiceResult<BenefitCategory> CreateSuccess(BenefitCategory benefitCategory) {
        return new ServiceResult<>(null, benefitCategory);
    }

    public static ServiceResult<BenefitCategory> UpdateFail() {
        return new ServiceResult<>(BenefitCategoryNotificationFactory.UpdateBenefitCategoryFail(), null);
    }

    public static ServiceResult<BenefitCategory> UpdateSuccess(BenefitCategory benefitCategory) {
        return new ServiceResult<>(null, benefitCategory);
    }

    public static ServiceResult<BenefitCategory> DeleteSuccess(BenefitCategory benefitCategory) {
        return new ServiceResult<>(null, benefitCategory);
    }

    public static ServiceResult<BenefitCategory> DeleteFail() {
        return new ServiceResult<>(BenefitCategoryNotificationFactory.DeleteBenefitCategoryFail(), null);
    }

    public static ServiceResult<List<BenefitCategory>> FetchNull() {
        return new ServiceResult<>(BenefitCategoryNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<BenefitCategory>> FetchResult(List<BenefitCategory> benefitCategory) {
        return new ServiceResult<>(null, benefitCategory);
    }

}
