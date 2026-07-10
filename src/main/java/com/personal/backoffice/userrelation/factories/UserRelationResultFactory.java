package com.personal.backoffice.userrelation.factories;

import java.util.List;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrelation.notifications.UserRelationNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class UserRelationResultFactory {

    public static ServiceResult<UserRelation> CreateFail() {
        return new ServiceResult<>(UserRelationNotificationFactory.CreateUserRelationFail(), null);
    }

    public static ServiceResult<UserRelation> CreateSuccess(UserRelation userRelation) {
        return new ServiceResult<>(null, userRelation);
    }

    public static ServiceResult<UserRelation> UpdateFail() {
        return new ServiceResult<>(UserRelationNotificationFactory.UpdateUserRelationFail(), null);
    }

    public static ServiceResult<UserRelation> UpdateSuccess(UserRelation userRelation) {
        return new ServiceResult<>(null, userRelation);
    }

    public static ServiceResult<UserRelation> DeleteSuccess(UserRelation userRelation) {
        return new ServiceResult<>(null, userRelation);
    }

    public static ServiceResult<UserRelation> DeleteFail() {
        return new ServiceResult<>(UserRelationNotificationFactory.DeleteUserRelationFail(), null);
    }

    public static ServiceResult<List<UserRelation>> FetchNull() {
        return new ServiceResult<>(UserRelationNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<UserRelation>> FetchResult(List<UserRelation> userRelations) {
        return new ServiceResult<>(null, userRelations);
    }

}
