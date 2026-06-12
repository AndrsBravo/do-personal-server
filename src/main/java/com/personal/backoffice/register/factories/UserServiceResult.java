package com.personal.backoffice.register.factories;

import com.personal.backoffice.user.entities.User;
import com.personal.shared.notifications.Notification;
import com.personal.shared.services.ServiceResult;

public class UserServiceResult extends ServiceResult<User> {

    public UserServiceResult(Notification notification, User logged) {
        super(notification, logged);
    }

}
