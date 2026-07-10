package com.personal.management.orgrelation.factories;

import java.util.List;

import com.personal.management.orgrelation.entities.OrgRelation;
import com.personal.management.orgrelation.notifications.OrgRelationNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class OrgRelationResultFactory {

    public static ServiceResult<OrgRelation> CreateFail() {
        return new ServiceResult<>(OrgRelationNotificationFactory.CreateOrgRelationFail(), null);
    }

    public static ServiceResult<OrgRelation> CreateSuccess(OrgRelation orgRelation) {
        return new ServiceResult<>(null, orgRelation);
    }

    public static ServiceResult<OrgRelation> UpdateFail() {
        return new ServiceResult<>(OrgRelationNotificationFactory.UpdateOrgRelationFail(), null);
    }

    public static ServiceResult<OrgRelation> UpdateSuccess(OrgRelation orgRelation) {
        return new ServiceResult<>(null, orgRelation);
    }

    public static ServiceResult<OrgRelation> DeleteSuccess(OrgRelation orgRelation) {
        return new ServiceResult<>(null, orgRelation);
    }

    public static ServiceResult<OrgRelation> DeleteFail() {
        return new ServiceResult<>(OrgRelationNotificationFactory.DeleteOrgRelationFail(), null);
    }

    public static ServiceResult<List<OrgRelation>> FetchNull() {
        return new ServiceResult<>(OrgRelationNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<OrgRelation>> FetchResult(List<OrgRelation> orgRelation) {
        return new ServiceResult<>(null, orgRelation);
    }

}
