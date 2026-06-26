package com.personal.backoffice.userrole.create.services;

import java.util.Optional;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.factories.UserRoleResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateUserRoleService implements ICreateService<UserRole> {

    private final Optional<DbClient> dbClient;

    public CreateUserRoleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<UserRole> create(Query query) {
        if (dbClient.isEmpty()) {
            return UserRoleResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("user_role").Get();

        System.out.println(insertQuery);
        long result = 0;

        result = dbclient.execute()
                .createInsert(insertQuery)
                .params(query.getParams())
                .execute();

        try {

        } catch (Exception e) {

            return UserRoleResultFactory.CreateFail();
        }

        if (result == 0) {
            return UserRoleResultFactory.CreateFail();
        }

        return UserRoleResultFactory.CreateSuccess(new UserRole());

    }

}
