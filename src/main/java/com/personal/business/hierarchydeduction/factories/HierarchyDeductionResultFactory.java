package com.personal.business.hierarchydeduction.factories;

import java.util.List;

import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.notifications.HierarchyDeductionNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class HierarchyDeductionResultFactory {

    public static ServiceResult<HierarchyDeduction> CreateFail() {
        return new ServiceResult<>(HierarchyDeductionNotificationFactory.CreateHierarchyDeductionFail(), null);
    }

    public static ServiceResult<HierarchyDeduction> CreateSuccess(HierarchyDeduction hierarchyDeduction) {
        return new ServiceResult<>(null, hierarchyDeduction);
    }

    public static ServiceResult<HierarchyDeduction> UpdateFail() {
        return new ServiceResult<>(HierarchyDeductionNotificationFactory.UpdateHierarchyDeductionFail(), null);
    }

    public static ServiceResult<HierarchyDeduction> UpdateSuccess(HierarchyDeduction hierarchyDeduction) {
        return new ServiceResult<>(null, hierarchyDeduction);
    }

    public static ServiceResult<HierarchyDeduction> DeleteSuccess(HierarchyDeduction hierarchyDeduction) {
        return new ServiceResult<>(null, hierarchyDeduction);
    }

    public static ServiceResult<HierarchyDeduction> DeleteFail() {
        return new ServiceResult<>(HierarchyDeductionNotificationFactory.DeleteHierarchyDeductionFail(), null);
    }

    public static ServiceResult<List<HierarchyDeduction>> FetchNull() {
        return new ServiceResult<>(HierarchyDeductionNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<HierarchyDeduction>> FetchResult(List<HierarchyDeduction> hierarchyDeduction) {
        return new ServiceResult<>(null, hierarchyDeduction);
    }

}
