package com.personal.backoffice.userrole.factories;

import java.util.List;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.notifications.UserRoleNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class UserRoleResultFactory {

    public static ServiceResult<UserRole> CreateFail() {
        return new ServiceResult<>(UserRoleNotificationFactory.CreateUserRoleFail(), null);
    }

    public static ServiceResult<UserRole> CreateSuccess(UserRole userRole) {
        return new ServiceResult<>(null, userRole);
    }

    public static ServiceResult<UserRole> UpdateFail() {
        return new ServiceResult<>(UserRoleNotificationFactory.UpdateUserRoleFail(), null);
    }

    public static ServiceResult<UserRole> UpdateSuccess(UserRole userRole) {
        return new ServiceResult<>(null, userRole);
    }

    public static ServiceResult<UserRole> DeleteSuccess(UserRole userRole) {
        return new ServiceResult<>(null, userRole);
    }

    public static ServiceResult<UserRole> DeleteFail() {
        return new ServiceResult<>(UserRoleNotificationFactory.DeleteUserRoleFail(), null);
    }

    public static ServiceResult<List<UserRole>> FetchNull() {
        return new ServiceResult<>(UserRoleNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<UserRole>> FetchResult(List<UserRole> userRoles) {
        return new ServiceResult<>(null, userRoles);
    }

}
