package com.personal.backoffice.user.associatebusiness.delete.services;

import java.util.Optional;

import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.factories.UserResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteAssociatedUserBusinessService implements IDeleteService<AssociateUserBusiness> {

    private final Optional<DbClient> dbClient;

    public DeleteAssociatedUserBusinessService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<AssociateUserBusiness> delete(Query query) {
        if (dbClient.isEmpty()) {
            return UserResultFactory.DeleteAssociatedUserBusinessFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("user_has_business").Get();

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
            //System.out.println("Hubo una excepción al eliminar la relación Usuario, Empresa " + e.getMessage());
            return UserResultFactory.DeleteAssociatedUserBusinessFail();
        }

        if (result == 0) {
            return UserResultFactory.DeleteAssociatedUserBusinessFail();
        }

        return UserResultFactory.DeleteAssociatedUserBusinessSuccess(new AssociateUserBusiness(query.getParams().get("id")));

    }

}
