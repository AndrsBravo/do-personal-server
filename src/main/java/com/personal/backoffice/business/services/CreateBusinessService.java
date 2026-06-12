package com.personal.backoffice.business.services;

import java.util.Optional;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.business.factories.BusinessResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateBusinessService implements ICreateService<Business> {

    private final Optional<DbClient> dbBusiness;

    public CreateBusinessService(Optional<DbClient> dbBusiness) {
        this.dbBusiness = dbBusiness;
    }

    @Override
    public ServiceResult<Business> create(Query query) {
        if (dbBusiness.isEmpty()) {
            return BusinessResultFactory.CreateFail();
        }

        var dbclient = dbBusiness.get();

        var insertQuery = query.InsertInto("business").Get();

        System.out.println(insertQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de empresa " + e.getMessage());
            return BusinessResultFactory.CreateFail();
        }

        if (result == 0) {
            return BusinessResultFactory.CreateFail();
        }

        return BusinessResultFactory.CreateSuccess(new Business());

    }

}
