package com.personal.business.orgstructure.factories;

import java.util.List;

import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.business.orgstructure.notifications.OrgStructureNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class OrgStructureResultFactory {

    public static ServiceResult<OrgStructure> CreateFail() {
        return new ServiceResult<>(OrgStructureNotificationFactory.CreateOrgStructureFail(), null);
    }

    public static ServiceResult<OrgStructure> CreateSuccess(OrgStructure orgStructure) {
        return new ServiceResult<>(null, orgStructure);
    }

    public static ServiceResult<OrgStructure> UpdateFail() {
        return new ServiceResult<>(OrgStructureNotificationFactory.UpdateOrgStructureFail(), null);
    }

    public static ServiceResult<OrgStructure> UpdateSuccess(OrgStructure orgStructure) {
        return new ServiceResult<>(null, orgStructure);
    }

    public static ServiceResult<OrgStructure> DeleteSuccess(OrgStructure orgStructure) {
        return new ServiceResult<>(null, orgStructure);
    }

    public static ServiceResult<OrgStructure> DeleteFail() {
        return new ServiceResult<>(OrgStructureNotificationFactory.DeleteOrgStructureFail(), null);
    }

    public static ServiceResult<List<OrgStructure>> FetchNull() {
        return new ServiceResult<>(OrgStructureNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<OrgStructure>> FetchResult(List<OrgStructure> orgStructure) {
        return new ServiceResult<>(null, orgStructure);
    }

}
