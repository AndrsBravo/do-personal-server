package com.personal.backoffice.usertype.factories;

import java.util.List;

import com.personal.backoffice.usertype.notifications.UserTypeNotificationFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.services.ServiceResult;

public class UserTypeResultFactory {

    public static ServiceResult<TypeEntityBase> CreateFail() {
        return new ServiceResult<>(UserTypeNotificationFactory.CreateUserTypeFail(), null);
    }

    public static ServiceResult<TypeEntityBase> CreateSuccess(TypeEntityBase userType) {
        return new ServiceResult<>(null, userType);
    }

    public static ServiceResult<TypeEntityBase> UpdateFail() {
        return new ServiceResult<>(UserTypeNotificationFactory.UpdateUserTypeFail(), null);
    }

    public static ServiceResult<TypeEntityBase> UpdateSuccess(TypeEntityBase userType) {
        return new ServiceResult<>(null, userType);
    }

    public static ServiceResult<TypeEntityBase> DeleteSuccess(TypeEntityBase userType) {
        return new ServiceResult<>(null, userType);
    }

    public static ServiceResult<TypeEntityBase> DeleteFail() {
        return new ServiceResult<>(UserTypeNotificationFactory.DeleteUserTypeFail(), null);
    }

    public static ServiceResult<List<TypeEntityBase>> FetchNull() {
        return new ServiceResult<>(UserTypeNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<TypeEntityBase>> FetchResult(List<TypeEntityBase> userTypes) {
        return new ServiceResult<>(null, userTypes);
    }

}
