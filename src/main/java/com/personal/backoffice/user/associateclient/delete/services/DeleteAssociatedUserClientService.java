package com.personal.backoffice.user.associateclient.delete.services;

import java.util.Optional;

import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteAssociatedUserClientService implements IDeleteService<AssociateUserClient> {

    private final Optional<DbClient> dbClient;

    public DeleteAssociatedUserClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<AssociateUserClient> delete(Query query) {
        if (dbClient.isEmpty()) {
            return UserResultFactory.DeleteAssociatedUserClientFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("user_has_clients").Get();

        //System.out.println(deleteQuery);
        //System.out.println("Params " + query.getParams());
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();
            //System.out.println("Result " + result);

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar la relación Usuario, Cliente " + e.getMessage());
            return UserResultFactory.DeleteAssociatedUserClientFail();
        }

        if (result == 0) {
            return UserResultFactory.DeleteAssociatedUserClientFail();
        }

        return UserResultFactory.DeleteAssociatedUserClientSuccess(new AssociateUserClient(query.getParams().get("id")));

    }

}
