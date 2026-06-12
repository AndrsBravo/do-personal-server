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
import com.personal.backoffice.user.create.services.CreateUserService;
import com.personal.backoffice.user.filter.services.FilterUserService;
import com.personal.backoffice.user.update.services.EditUserService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

import io.helidon.dbclient.DbClient;

public class UserServiceFactory {

    private static Optional<DbClient> dbClient = DbClientMSSQLFactory.SystemMaster();

    public static CreateUserService CreateUser() {

        return new CreateUserService(dbClient);

    }

    public static EditUserService EditUser() {

        return new EditUserService(dbClient);

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
