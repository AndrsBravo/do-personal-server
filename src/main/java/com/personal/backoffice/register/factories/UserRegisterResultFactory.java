package com.personal.backoffice.register.factories;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class UserRegisterResultFactory {

    public static ServiceResult<User> LoginFailResult(User user) {
        return new ServiceResult(UserNotificationFactory.LoginFail(user), user);
    }

}
