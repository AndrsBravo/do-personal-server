package com.personal.backoffice.userrole.factories;

import com.personal.backoffice.userrole.filter.services.FilterUserRoleService;
import com.personal.backoffice.userrole.notifications.UserRoleNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class UserRoleServiceFactory {

    private static final String TABLE_NAME = "user_role";

    public static CreateService CreateUserRole() {
        return CreateServiceBuilder
                .builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserRoleNotificationFactory.CreateUserRoleSuccess())
                .withFailureNotification(UserRoleNotificationFactory.CreateUserRoleFail())
                .build();
    }

    public static FilterUserRoleService FilterUserRoles() {

        return new FilterUserRoleService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditUserRole() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserRoleNotificationFactory.UpdateUserRoleSuccess())
                .withFailureNotification(UserRoleNotificationFactory.UpdateUserRoleFail())
                .build();
    }

    public static DeleteService DeleteUserRole() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserRoleNotificationFactory.DeleteUserRoleSuccess())
                .withFailureNotification(UserRoleNotificationFactory.DeleteUserRoleFail())
                .build();
    }

}
