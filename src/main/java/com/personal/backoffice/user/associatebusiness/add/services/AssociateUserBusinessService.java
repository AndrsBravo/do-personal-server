package com.personal.backoffice.user.associatebusiness.add.services;

import java.util.Optional;

import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class AssociateUserBusinessService implements ICreateService<AssociateUserBusiness> {

    private final Optional<DbClient> dbClient;

    public AssociateUserBusinessService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<AssociateUserBusiness> create(Query query) {
        if (dbClient.isEmpty()) {
            return UserResultFactory.AssociateUserBusinessFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("user_has_business").Get();

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
            return UserResultFactory.AssociateUserBusinessFail();
        }

        if (result == 0) {
            return UserResultFactory.AssociateUserBusinessFail();
        }

        return UserResultFactory.AssociateUserBusinessSuccess(new AssociateUserBusiness());

    }

}
