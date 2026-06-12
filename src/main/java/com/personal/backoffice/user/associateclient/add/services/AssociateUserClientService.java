package com.personal.backoffice.user.associateclient.add.services;

import java.util.Optional;

import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class AssociateUserClientService implements ICreateService<AssociateUserClient> {

    private final Optional<DbClient> dbClient;

    public AssociateUserClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<AssociateUserClient> create(Query query) {
        if (dbClient.isEmpty()) {
            return UserResultFactory.AssociateUserClientFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("user_has_clients").Get();

        //System.out.println(insertQuery);
        //System.out.println(query.getParams());
        long result = 0;

        result = dbclient.execute()
                .createInsert(insertQuery)
                .params(query.getParams())
                .execute();

        try {
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al asociar usuario al Cliente " + e.getMessage());
            return UserResultFactory.AssociateUserClientFail();
        }

        if (result == 0) {
            return UserResultFactory.AssociateUserClientFail();
        }

        return UserResultFactory.AssociateUserClientSuccess(new AssociateUserClient());

    }

}
