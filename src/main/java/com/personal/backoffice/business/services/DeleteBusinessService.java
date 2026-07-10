package com.personal.backoffice.business.services;

import java.util.Optional;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.factories.BusinessResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteBusinessService implements IDeleteService<Business> {

    private final Optional<DbClient> dbBusiness;

    public DeleteBusinessService(Optional<DbClient> dbBusiness) {
        this.dbBusiness = dbBusiness;
    }

    @Override
    public ServiceResult<Business> delete(Query query) {
        if (dbBusiness.isEmpty()) {
            return BusinessResultFactory.DeleteFail();
        }

        var dbclient = dbBusiness.get();

        var deleteQuery = query.Delete("business").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de empresa " + e.getMessage());
            return BusinessResultFactory.DeleteFail();
        }

        if (result == 0) {
            return BusinessResultFactory.DeleteFail();
        }

        return BusinessResultFactory.DeleteSuccess(new Business(query.getParams().get("id")));

    }

}
