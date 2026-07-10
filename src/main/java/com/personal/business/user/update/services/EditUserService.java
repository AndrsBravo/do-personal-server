package com.personal.business.user.update.services;

import java.util.Optional;

import com.personal.business.user.entities.User;
import com.personal.business.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditUserService implements IEditService<User> {

    private final Optional<DbClient> dbClient;

    public EditUserService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<User> edit(Query query) {

        if (dbClient.isEmpty()) {
            return UserResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var userQuery = query.Update("users").Get();
        //System.out.println("id " + query.getParams().get("id"));
        //System.out.println("us_last_name " + query.getParams().get("us_last_name"));

        //System.out.println(userQuery);
        var userResult = dbclient.execute()
                .createUpdate(userQuery)
                .params(query.getParams())
                .execute();

        //System.out.println("userResult " + userResult);
        if (userResult == 0) {
            return UserResultFactory.UpdateFail();
        }
        return UserResultFactory.UpdateSuccess(new User(query.getParams().get("id")));

    }
}
