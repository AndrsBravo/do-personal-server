package com.personal.business.hierarchydeductionfeed.factories;

import java.util.List;

import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.hierarchydeductionfeed.notifications.HierarchyDeductionFeedNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class HierarchyDeductionFeedResultFactory {

    public static ServiceResult<HierarchyDeductionFeed> CreateFail() {
        return new ServiceResult<>(HierarchyDeductionFeedNotificationFactory.CreateHierarchyDeductionFeedFail(), null);
    }

    public static ServiceResult<HierarchyDeductionFeed> CreateSuccess(HierarchyDeductionFeed hierarchyDeductionFeed) {
        return new ServiceResult<>(null, hierarchyDeductionFeed);
    }

    public static ServiceResult<HierarchyDeductionFeed> UpdateFail() {
        return new ServiceResult<>(HierarchyDeductionFeedNotificationFactory.UpdateHierarchyDeductionFeedFail(), null);
    }

    public static ServiceResult<HierarchyDeductionFeed> UpdateSuccess(HierarchyDeductionFeed hierarchyDeductionFeed) {
        return new ServiceResult<>(null, hierarchyDeductionFeed);
    }

    public static ServiceResult<HierarchyDeductionFeed> DeleteSuccess(HierarchyDeductionFeed hierarchyDeductionFeed) {
        return new ServiceResult<>(null, hierarchyDeductionFeed);
    }

    public static ServiceResult<HierarchyDeductionFeed> DeleteFail() {
        return new ServiceResult<>(HierarchyDeductionFeedNotificationFactory.DeleteHierarchyDeductionFeedFail(), null);
    }

    public static ServiceResult<List<HierarchyDeductionFeed>> FetchNull() {
        return new ServiceResult<>(HierarchyDeductionFeedNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<HierarchyDeductionFeed>> FetchResult(List<HierarchyDeductionFeed> hierarchyDeductionFeed) {
        return new ServiceResult<>(null, hierarchyDeductionFeed);
    }

}
