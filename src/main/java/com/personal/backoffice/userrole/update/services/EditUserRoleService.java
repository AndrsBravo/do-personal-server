package com.personal.backoffice.userrole.update.services;

import java.util.Optional;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.factories.UserRoleResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditUserRoleService implements IEditService<UserRole> {

    private final Optional<DbClient> dbClient;

    public EditUserRoleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<UserRole> edit(Query query) {

        if (dbClient.isEmpty()) {
            return UserRoleResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("user_role").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return UserRoleResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return UserRoleResultFactory.UpdateFail();
        }

        return UserRoleResultFactory.UpdateSuccess(new UserRole());

    }

}
