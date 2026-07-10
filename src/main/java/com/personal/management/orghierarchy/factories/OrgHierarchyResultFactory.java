package com.personal.management.orghierarchy.factories;

import java.util.List;

import com.personal.management.orghierarchy.entities.OrgHierarchy;
import com.personal.management.orghierarchy.notifications.OrgHierarchyNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class OrgHierarchyResultFactory {

    public static ServiceResult<OrgHierarchy> CreateFail() {
        return new ServiceResult<>(OrgHierarchyNotificationFactory.CreateOrgHierarchyFail(), null);
    }

    public static ServiceResult<OrgHierarchy> CreateSuccess(OrgHierarchy orgHierarchy) {
        return new ServiceResult<>(null, orgHierarchy);
    }

    public static ServiceResult<OrgHierarchy> UpdateFail() {
        return new ServiceResult<>(OrgHierarchyNotificationFactory.UpdateOrgHierarchyFail(), null);
    }

    public static ServiceResult<OrgHierarchy> UpdateSuccess(OrgHierarchy orgHierarchy) {
        return new ServiceResult<>(null, orgHierarchy);
    }

    public static ServiceResult<OrgHierarchy> DeleteSuccess(OrgHierarchy orgHierarchy) {
        return new ServiceResult<>(null, orgHierarchy);
    }

    public static ServiceResult<OrgHierarchy> DeleteFail() {
        return new ServiceResult<>(OrgHierarchyNotificationFactory.DeleteOrgHierarchyFail(), null);
    }

    public static ServiceResult<List<OrgHierarchy>> FetchNull() {
        return new ServiceResult<>(OrgHierarchyNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<OrgHierarchy>> FetchResult(List<OrgHierarchy> orgHierarchy) {
        return new ServiceResult<>(null, orgHierarchy);
    }

}
