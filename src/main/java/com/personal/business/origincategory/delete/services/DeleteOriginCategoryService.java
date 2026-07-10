package com.personal.business.origincategory.delete.services;

import java.util.Optional;

import com.personal.business.origincategory.entities.OriginCategory;
import com.personal.business.origincategory.factories.OriginCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteOriginCategoryService implements IDeleteService<OriginCategory> {

    private final Optional<DbClient> dbClient;

    public DeleteOriginCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OriginCategory> delete(Query query) {
        if (dbClient.isEmpty()) {
            return OriginCategoryResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("origin_categories").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return OriginCategoryResultFactory.DeleteFail();
        }

        if (result == 0) {
            return OriginCategoryResultFactory.DeleteFail();
        }

        return OriginCategoryResultFactory.DeleteSuccess(new OriginCategory(query.getParams().get("id")));

    }

}
