package com.personal.backoffice.usertype.delete.services;

import java.util.Optional;

import com.personal.backoffice.usertype.factories.UserTypeResultFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteUserTypeService implements IDeleteService<TypeEntityBase> {

    private final Optional<DbClient> dbClient;

    public DeleteUserTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TypeEntityBase> delete(Query query) {
        if (dbClient.isEmpty()) {
            return UserTypeResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("user_types").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return UserTypeResultFactory.DeleteFail();
        }

        if (result == 0) {
            return UserTypeResultFactory.DeleteFail();
        }

        return UserTypeResultFactory.DeleteSuccess(new TypeEntityBase(query.getParams().get("id")));

    }

}
