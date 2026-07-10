package com.personal.backoffice.user.factories;

import java.util.List;

import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.notifications.Notification;
import com.personal.shared.services.entities.ServiceResult;

public class UserResultFactory {

    public static ServiceResult<User> UserFound(User user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<User> ResultNull(Notification notification) {
        return new ServiceResult(notification, null);
    }

    public static ServiceResult<List<User>> FetchEmpty(String filter) {

        return new ServiceResult(UserNotificationFactory.FetchUserEmpty(filter), null);
    }

    public static ServiceResult<List<User>> FetchResult(List<User> result) {
        return new ServiceResult(null, result);
    }

    public static ServiceResult<User> ServiceResult(User user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<User> UpdateFail() {
        return new ServiceResult<>(UserNotificationFactory.UpdateUserFail(), null);
    }

    public static ServiceResult<User> UpdateSuccess(User user) {
        return new ServiceResult<>(null, user);
    }

    public static ServiceResult<User> UserCreated(User user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<User> CreateFail() {

        return new ServiceResult(UserNotificationFactory.CreateUserFail(), null);

    }

    public static ServiceResult<AssociateUserClient> AssociateUserClientFail() {

        return new ServiceResult(UserNotificationFactory.AssociateUserClientFail(), null);

    }

    public static ServiceResult<AssociateUserClient> AssociateUserClientSuccess(AssociateUserClient user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<AssociateUserClient> UpdateAssociatedUserClientSuccess(AssociateUserClient user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<AssociateUserClient> DeleteAssociatedUserClientFail() {

        return new ServiceResult(UserNotificationFactory.DeleteAssociatedUserClientFail(), null);

    }

    public static ServiceResult<AssociateUserClient> DeleteAssociatedUserClientSuccess(AssociateUserClient user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<AssociateUserClient> UpdateAssociatedUserClientFail() {
        return new ServiceResult(UserNotificationFactory.UpdateAssociatedUserClientFail(), null);
    }

    public static ServiceResult<List<AssociateUserClient>> FetchAssociatedUserClientFail() {

        return new ServiceResult(UserNotificationFactory.FetchAssociatedUserClientFail(), null);

    }

    public static ServiceResult<List<AssociateUserClient>> FetchAssociatedUserClientSuccess(List<AssociateUserClient> user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<AssociateUserBusiness> AssociateUserBusinessFail() {

        return new ServiceResult(UserNotificationFactory.AssociateUserBusinessFail(), null);

    }

    public static ServiceResult<AssociateUserBusiness> AssociateUserBusinessSuccess(AssociateUserBusiness user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<AssociateUserBusiness> UpdateAssociatedUserBusinessSuccess(AssociateUserBusiness user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<AssociateUserBusiness> DeleteAssociatedUserBusinessFail() {

        return new ServiceResult(UserNotificationFactory.DeleteAssociatedUserBusinessFail(), null);

    }

    public static ServiceResult<AssociateUserBusiness> DeleteAssociatedUserBusinessSuccess(AssociateUserBusiness user) {
        return new ServiceResult(null, user);
    }

    public static ServiceResult<AssociateUserBusiness> UpdateAssociatedUserBusinessFail() {
        return new ServiceResult(UserNotificationFactory.UpdateAssociatedUserBusinessFail(), null);
    }

    public static ServiceResult<List<AssociateUserBusiness>> FetchAssociatedUserBusinessFail() {

        return new ServiceResult(UserNotificationFactory.FetchAssociatedUserBusinessFail(), null);

    }

    public static ServiceResult<List<AssociateUserBusiness>> FetchAssociatedUserBusinessSuccess(List<AssociateUserBusiness> user) {
        return new ServiceResult(null, user);
    }
}
