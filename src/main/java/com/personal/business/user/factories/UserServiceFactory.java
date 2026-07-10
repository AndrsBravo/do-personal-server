package com.personal.business.user.factories;

import java.util.Optional;

import com.personal.business.user.filter.services.FilterUserService;
import com.personal.business.user.notifications.UserNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

import io.helidon.dbclient.DbClient;

public class UserServiceFactory {

    private static final String TABLE_NAME = "users";

    public static CreateService CreateUser(String dbName) {

        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbName))
                .withSuccessNotification(UserNotificationFactory.CreateUserSuccess())
                .withFailureNotification(UserNotificationFactory.CreateUserFail())
                .build();

    }

    public static UpdateService EditUser(String dbName) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbName))
                .withSuccessNotification(UserNotificationFactory.UpdateUserSuccess())
                .withFailureNotification(UserNotificationFactory.UpdateUserFail())
                .build();

    }

    public static FilterUserService FilterUser(String dbName) {

        Optional<DbClient> dbClient = DbClientMSSQLFactory.DbClient(dbName);

        return new FilterUserService(dbClient);

    }

}
