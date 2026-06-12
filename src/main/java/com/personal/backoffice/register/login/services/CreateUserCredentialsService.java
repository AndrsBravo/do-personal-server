package com.personal.backoffice.register.login.services;

import java.util.Optional;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateUserCredentialsService implements ICreateService<User> {

    private final Optional<DbClient> dbClient;

    public CreateUserCredentialsService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<User> create(Query query) {

        var oldCreadentialsQuery = "INSERT INTO credentials (id,user_id,password,salt,created_at,updated_at,created_by) VALUES (:id,:user_id,:password,:salt,:created_at,:updated_at,:created_by)";

        if (dbClient.isEmpty()) {
            return UserResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var credentialsQuery = query.InsertInto("credentials").Get();

        var credentialResult = dbclient.execute()
                .createInsert(credentialsQuery)
                .params(query.getParams())
                .execute();

        if (credentialResult == 0) {
            return UserResultFactory.CreateFail();
        }

        // return new UserServiceResult(null, insertRepositoryResult.getResult());
        return UserResultFactory.UserCreated(new User(query.getParams().get("id")));

    }
}
