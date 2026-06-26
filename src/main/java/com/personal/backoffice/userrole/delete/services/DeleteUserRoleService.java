package com.personal.backoffice.userrole.delete.services;

import java.util.Optional;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.factories.UserRoleResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteUserRoleService implements IDeleteService<UserRole> {

    private final Optional<DbClient> dbClient;

    public DeleteUserRoleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<UserRole> delete(Query query) {
        if (dbClient.isEmpty()) {
            return UserRoleResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("user_role").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return UserRoleResultFactory.DeleteFail();
        }

        if (result == 0) {
            return UserRoleResultFactory.DeleteFail();
        }

        return UserRoleResultFactory.DeleteSuccess(new UserRole(query.getParams().get("id")));

    }

}
