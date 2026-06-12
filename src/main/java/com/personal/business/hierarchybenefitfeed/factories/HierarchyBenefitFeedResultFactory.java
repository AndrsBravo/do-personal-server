package com.personal.business.hierarchybenefitfeed.factories;

import java.util.List;

import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.hierarchybenefitfeed.notifications.HierarchyBenefitFeedNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class HierarchyBenefitFeedResultFactory {

    public static ServiceResult<HierarchyBenefitFeed> CreateFail() {
        return new ServiceResult<>(HierarchyBenefitFeedNotificationFactory.CreateHierarchyBenefitFeedFail(), null);
    }

    public static ServiceResult<HierarchyBenefitFeed> CreateSuccess(HierarchyBenefitFeed hierarchyBenefitFeed) {
        return new ServiceResult<>(null, hierarchyBenefitFeed);
    }

    public static ServiceResult<HierarchyBenefitFeed> UpdateFail() {
        return new ServiceResult<>(HierarchyBenefitFeedNotificationFactory.UpdateHierarchyBenefitFeedFail(), null);
    }

    public static ServiceResult<HierarchyBenefitFeed> UpdateSuccess(HierarchyBenefitFeed hierarchyBenefitFeed) {
        return new ServiceResult<>(null, hierarchyBenefitFeed);
    }

    public static ServiceResult<HierarchyBenefitFeed> DeleteSuccess(HierarchyBenefitFeed hierarchyBenefitFeed) {
        return new ServiceResult<>(null, hierarchyBenefitFeed);
    }

    public static ServiceResult<HierarchyBenefitFeed> DeleteFail() {
        return new ServiceResult<>(HierarchyBenefitFeedNotificationFactory.DeleteHierarchyBenefitFeedFail(), null);
    }

    public static ServiceResult<List<HierarchyBenefitFeed>> FetchNull() {
        return new ServiceResult<>(HierarchyBenefitFeedNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<HierarchyBenefitFeed>> FetchResult(List<HierarchyBenefitFeed> hierarchyBenefitFeed) {
        return new ServiceResult<>(null, hierarchyBenefitFeed);
    }

}
