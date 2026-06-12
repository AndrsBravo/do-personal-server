package com.personal.backoffice.userrelation.delete.services;

import java.util.Optional;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrelation.factories.UserRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteUserRelationService implements IDeleteService<UserRelation> {

    private final Optional<DbClient> dbClient;

    public DeleteUserRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<UserRelation> delete(Query query) {
        if (dbClient.isEmpty()) {
            return UserRelationResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("user_relation").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return UserRelationResultFactory.DeleteFail();
        }

        if (result == 0) {
            return UserRelationResultFactory.DeleteFail();
        }

        return UserRelationResultFactory.DeleteSuccess(new UserRelation(query.getParams().get("id")));

    }

}
