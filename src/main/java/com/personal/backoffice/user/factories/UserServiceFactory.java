package com.personal.backoffice.user.factories;

import java.util.Optional;

import com.personal.backoffice.user.associatebusiness.add.services.AssociateUserBusinessService;
import com.personal.backoffice.user.associatebusiness.delete.services.DeleteAssociatedUserBusinessService;
import com.personal.backoffice.user.associatebusiness.filter.services.FilterAssociatedUserBusinessService;
import com.personal.backoffice.user.associatebusiness.update.services.UpdateAssociatedUserBusinessService;
import com.personal.backoffice.user.associateclient.add.services.AssociateUserClientService;
import com.personal.backoffice.user.associateclient.delete.services.DeleteAssociatedUserClientService;
import com.personal.backoffice.user.associateclient.filter.services.FilterAssociatedUserClientService;
import com.personal.backoffice.user.associateclient.update.services.UpdateAssociatedUserClientService;
import com.personal.backoffice.user.filter.services.FilterUserService;
import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

import io.helidon.dbclient.DbClient;

public class UserServiceFactory {

    private static final String TABLE_NAME = "users";
    private static Optional<DbClient> dbClient = DbClientMSSQLFactory.SystemMaster();

    public static CreateService CreateUser() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(dbClient)
                .withSuccessNotification(UserNotificationFactory.CreateUserSuccess())
                .withFailureNotification(UserNotificationFactory.CreateUserFail())
                .build();
    }

    public static UpdateService EditUser() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(dbClient)
                .withSuccessNotification(UserNotificationFactory.UpdateUserSuccess())
                .withFailureNotification(UserNotificationFactory.UpdateUserFail())
                .build();

    }

    public static FilterUserService FilterUser() {

        return new FilterUserService(dbClient);

    }

    public static AssociateUserClientService AssociateUserClient() {

        return new AssociateUserClientService(dbClient);

    }

    public static UpdateAssociatedUserClientService UpdateAssociatedUserClient() {

        return new UpdateAssociatedUserClientService(dbClient);

    }

    public static FilterAssociatedUserClientService FilterAssociatedUserClient() {

        return new FilterAssociatedUserClientService(dbClient);

    }

    public static DeleteAssociatedUserClientService DeleteAssociatedUserClientService() {

        return new DeleteAssociatedUserClientService(dbClient);

    }

    public static AssociateUserBusinessService AssociateUserBusiness() {

        return new AssociateUserBusinessService(dbClient);

    }

    public static UpdateAssociatedUserBusinessService UpdateAssociatedUserBusiness() {

        return new UpdateAssociatedUserBusinessService(dbClient);

    }

    public static FilterAssociatedUserBusinessService FilterAssociatedUserBusiness() {

        return new FilterAssociatedUserBusinessService(dbClient);

    }

    public static DeleteAssociatedUserBusinessService DeleteAssociatedUserBusinessService() {

        return new DeleteAssociatedUserBusinessService(dbClient);

    }
}
