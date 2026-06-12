package com.personal.business.origincategory.create.services;

import java.util.Optional;

import com.personal.business.origincategory.entities.OriginCategory;
import com.personal.business.origincategory.factories.OriginCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateOriginCategoryService implements ICreateService<OriginCategory> {

    private final Optional<DbClient> dbClient;

    public CreateOriginCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OriginCategory> create(Query query) {
        if (dbClient.isEmpty()) {
            return OriginCategoryResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("origin_categories").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return OriginCategoryResultFactory.CreateFail();
        }

        if (result == 0) {
            return OriginCategoryResultFactory.CreateFail();
        }

        return OriginCategoryResultFactory.CreateSuccess(new OriginCategory());

    }

}
