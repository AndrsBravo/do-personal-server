package com.personal.business.origincategory.update.services;

import java.util.Optional;

import com.personal.business.origincategory.entities.OriginCategory;
import com.personal.business.origincategory.factories.OriginCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditOriginCategoryService implements IEditService<OriginCategory> {

    private final Optional<DbClient> dbClient;

    public EditOriginCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OriginCategory> edit(Query query) {

        if (dbClient.isEmpty()) {
            return OriginCategoryResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("origin_categories").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return OriginCategoryResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return OriginCategoryResultFactory.UpdateFail();
        }

        return OriginCategoryResultFactory.UpdateSuccess(new OriginCategory());

    }

}
