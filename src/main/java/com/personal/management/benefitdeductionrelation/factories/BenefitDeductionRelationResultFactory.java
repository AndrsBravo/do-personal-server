package com.personal.management.benefitdeductionrelation.factories;

import java.util.List;

import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.management.benefitdeductionrelation.notifications.BenefitDeductionRelationNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class BenefitDeductionRelationResultFactory {

    public static ServiceResult<BenefitDeductionRelation> CreateFail() {
        return new ServiceResult<>(BenefitDeductionRelationNotificationFactory.CreateBenefitDeductionRelationFail(), null);
    }

    public static ServiceResult<BenefitDeductionRelation> CreateSuccess(BenefitDeductionRelation benefitDeductionRelation) {
        return new ServiceResult<>(null, benefitDeductionRelation);
    }

    public static ServiceResult<BenefitDeductionRelation> UpdateFail() {
        return new ServiceResult<>(BenefitDeductionRelationNotificationFactory.UpdateBenefitDeductionRelationFail(), null);
    }

    public static ServiceResult<BenefitDeductionRelation> UpdateSuccess(BenefitDeductionRelation benefitDeductionRelation) {
        return new ServiceResult<>(null, benefitDeductionRelation);
    }

    public static ServiceResult<BenefitDeductionRelation> DeleteSuccess(BenefitDeductionRelation benefitDeductionRelation) {
        return new ServiceResult<>(null, benefitDeductionRelation);
    }

    public static ServiceResult<BenefitDeductionRelation> DeleteFail() {
        return new ServiceResult<>(BenefitDeductionRelationNotificationFactory.DeleteBenefitDeductionRelationFail(), null);
    }

    public static ServiceResult<List<BenefitDeductionRelation>> FetchNull() {
        return new ServiceResult<>(BenefitDeductionRelationNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<BenefitDeductionRelation>> FetchResult(List<BenefitDeductionRelation> benefitDeductionRelation) {
        return new ServiceResult<>(null, benefitDeductionRelation);
    }

}
