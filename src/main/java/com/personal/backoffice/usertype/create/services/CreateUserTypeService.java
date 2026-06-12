package com.personal.backoffice.usertype.create.services;

import java.util.Optional;

import com.personal.backoffice.usertype.factories.UserTypeResultFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateUserTypeService implements ICreateService<TypeEntityBase> {

    private final Optional<DbClient> dbClient;

    public CreateUserTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TypeEntityBase> create(Query query) {
        if (dbClient.isEmpty()) {
            return UserTypeResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("user_types").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return UserTypeResultFactory.CreateFail();
        }

        if (result == 0) {
            return UserTypeResultFactory.CreateFail();
        }

        return UserTypeResultFactory.CreateSuccess(new TypeEntityBase());

    }

}
