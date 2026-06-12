package com.personal.business.user.factories;

import java.util.Optional;

import com.personal.business.user.create.services.CreateUserService;
import com.personal.business.user.filter.services.FilterUserService;
import com.personal.business.user.update.services.EditUserService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

import io.helidon.dbclient.DbClient;

public class UserServiceFactory {

    public static CreateUserService CreateUser(String dbName) {

        Optional<DbClient> dbClient = DbClientMSSQLFactory.DbClient(dbName);

        return new CreateUserService(dbClient);

    }

    public static EditUserService EditUser(String dbName) {

        Optional<DbClient> dbClient = DbClientMSSQLFactory.DbClient(dbName);

        return new EditUserService(dbClient);

    }

    public static FilterUserService FilterUser(String dbName) {

        Optional<DbClient> dbClient = DbClientMSSQLFactory.DbClient(dbName);

        return new FilterUserService(dbClient);

    }

}
