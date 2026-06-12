package com.personal.business.hierarchy.factories;

import java.util.List;

import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.notifications.HierarchyNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class HierarchyResultFactory {

    public static ServiceResult<Hierarchy> CreateFail() {
        return new ServiceResult<>(HierarchyNotificationFactory.CreateHierarchyFail(), null);
    }

    public static ServiceResult<Hierarchy> CreateSuccess(Hierarchy hierarchy) {
        return new ServiceResult<>(null, hierarchy);
    }

    public static ServiceResult<Hierarchy> UpdateFail() {
        return new ServiceResult<>(HierarchyNotificationFactory.UpdateHierarchyFail(), null);
    }

    public static ServiceResult<Hierarchy> UpdateSuccess(Hierarchy hierarchy) {
        return new ServiceResult<>(null, hierarchy);
    }

    public static ServiceResult<Hierarchy> DeleteSuccess(Hierarchy hierarchy) {
        return new ServiceResult<>(null, hierarchy);
    }

    public static ServiceResult<Hierarchy> DeleteFail() {
        return new ServiceResult<>(HierarchyNotificationFactory.DeleteHierarchyFail(), null);
    }

    public static ServiceResult<List<Hierarchy>> FetchNull() {
        return new ServiceResult<>(HierarchyNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Hierarchy>> FetchResult(List<Hierarchy> hierarchy) {
        return new ServiceResult<>(null, hierarchy);
    }

}
