package com.personal.backoffice.usertype.factories;

import com.personal.backoffice.usertype.filter.services.FilterUserTypeService;
import com.personal.backoffice.usertype.notifications.UserTypeNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class UserTypeServiceFactory {

    public static CreateService CreateUserType() {

        return CreateServiceBuilder
                .builder()
                .withTableName("user_types")
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserTypeNotificationFactory.CreateUserTypeSuccess())
                .withFailureNotification(UserTypeNotificationFactory.CreateUserTypeFail())
                .build();

    }

    public static FilterUserTypeService FilterUserTypes() {

        return new FilterUserTypeService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditUserType() {

        return UpdateServiceBuilder.builder()
                .withTableName("user_types")
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserTypeNotificationFactory.UpdateUserTypeSuccess())
                .withFailureNotification(UserTypeNotificationFactory.UpdateUserTypeFail())
                .build();

    }

    public static DeleteService DeleteUserType() {

        return DeleteServiceBuilder.builder()
                .withTableName("user_types")
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserTypeNotificationFactory.DeleteUserTypeSuccess())
                .withFailureNotification(UserTypeNotificationFactory.DeleteUserTypeFail())
                .build();

    }

}
