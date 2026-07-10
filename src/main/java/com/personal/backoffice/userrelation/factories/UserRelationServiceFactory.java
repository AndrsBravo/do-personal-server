package com.personal.backoffice.userrelation.factories;

import com.personal.backoffice.userrelation.filter.services.FilterUserRelationService;
import com.personal.backoffice.userrelation.notifications.UserRelationNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class UserRelationServiceFactory {

    private static final String TABLE_NAME = "user_relation";

    public static CreateService CreateUserRelation() {
        return CreateServiceBuilder
                .builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserRelationNotificationFactory.CreateUserRelationSuccess())
                .withFailureNotification(UserRelationNotificationFactory.CreateUserRelationFail())
                .build();
    }

    public static FilterUserRelationService FilterUserRelations() {

        return new FilterUserRelationService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditUserRelation() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserRelationNotificationFactory.UpdateUserRelationSuccess())
                .withFailureNotification(UserRelationNotificationFactory.UpdateUserRelationFail())
                .build();
    }

    public static DeleteService DeleteUserRelation() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(UserRelationNotificationFactory.DeleteUserRelationSuccess())
                .withFailureNotification(UserRelationNotificationFactory.DeleteUserRelationFail())
                .build();
    }

}
