package com.personal.backoffice.userrelation.update.services;

import java.util.Optional;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrelation.factories.UserRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditUserRelationService implements IEditService<UserRelation> {

    private final Optional<DbClient> dbClient;

    public EditUserRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<UserRelation> edit(Query query) {

        if (dbClient.isEmpty()) {
            return UserRelationResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("user_relation").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return UserRelationResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return UserRelationResultFactory.UpdateFail();
        }

        return UserRelationResultFactory.UpdateSuccess(new UserRelation());

    }

}
