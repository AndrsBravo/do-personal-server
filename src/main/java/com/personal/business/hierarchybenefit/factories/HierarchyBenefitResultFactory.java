package com.personal.business.hierarchybenefit.factories;

import java.util.List;

import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.notifications.HierarchyBenefitNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class HierarchyBenefitResultFactory {

    public static ServiceResult<HierarchyBenefit> CreateFail() {
        return new ServiceResult<>(HierarchyBenefitNotificationFactory.CreateHierarchyBenefitFail(), null);
    }

    public static ServiceResult<HierarchyBenefit> CreateSuccess(HierarchyBenefit hierarchyBenefit) {
        return new ServiceResult<>(null, hierarchyBenefit);
    }

    public static ServiceResult<HierarchyBenefit> UpdateFail() {
        return new ServiceResult<>(HierarchyBenefitNotificationFactory.UpdateHierarchyBenefitFail(), null);
    }

    public static ServiceResult<HierarchyBenefit> UpdateSuccess(HierarchyBenefit hierarchyBenefit) {
        return new ServiceResult<>(null, hierarchyBenefit);
    }

    public static ServiceResult<HierarchyBenefit> DeleteSuccess(HierarchyBenefit hierarchyBenefit) {
        return new ServiceResult<>(null, hierarchyBenefit);
    }

    public static ServiceResult<HierarchyBenefit> DeleteFail() {
        return new ServiceResult<>(HierarchyBenefitNotificationFactory.DeleteHierarchyBenefitFail(), null);
    }

    public static ServiceResult<List<HierarchyBenefit>> FetchNull() {
        return new ServiceResult<>(HierarchyBenefitNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<HierarchyBenefit>> FetchResult(List<HierarchyBenefit> hierarchyBenefit) {
        return new ServiceResult<>(null, hierarchyBenefit);
    }

}
