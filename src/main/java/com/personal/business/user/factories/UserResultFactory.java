package com.personal.business.user.factories;

import java.util.List;

import com.personal.business.user.entities.User;
import com.personal.business.user.notifications.UserNotificationFactory;
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

}
