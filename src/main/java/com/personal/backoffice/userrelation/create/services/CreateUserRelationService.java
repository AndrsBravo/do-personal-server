package com.personal.backoffice.userrelation.create.services;

import java.util.Optional;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrelation.factories.UserRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateUserRelationService implements ICreateService<UserRelation> {

    private final Optional<DbClient> dbClient;

    public CreateUserRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<UserRelation> create(Query query) {
        if (dbClient.isEmpty()) {
            return UserRelationResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("user_relation").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return UserRelationResultFactory.CreateFail();
        }

        if (result == 0) {
            return UserRelationResultFactory.CreateFail();
        }

        return UserRelationResultFactory.CreateSuccess(new UserRelation());

    }

}
