package com.personal.business.user.create.services;

import java.util.Optional;

import com.personal.business.user.entities.User;
import com.personal.business.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateUserService implements ICreateService<User> {

    private final Optional<DbClient> dbClient;

    public CreateUserService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<User> create(Query query) {

        if (dbClient.isEmpty()) {
            return UserResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var userQuery = query.InsertInto("users").Get();

        //System.out.println(userQuery);
        var userResult = dbclient.execute()
                .createInsert(userQuery)
                .params(query.getParams())
                .execute();

        if (userResult == 0) {
            return UserResultFactory.CreateFail();
        }
        return UserResultFactory.UserCreated(new User(query.getParams().get("id")));

    }
}
