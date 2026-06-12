package com.personal.business.deductioncategory.update.services;

import java.util.Optional;

import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.business.deductioncategory.factories.DeductionCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditDeductionCategoryService implements IEditService<DeductionCategory> {

    private final Optional<DbClient> dbClient;

    public EditDeductionCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<DeductionCategory> edit(Query query) {

        if (dbClient.isEmpty()) {
            return DeductionCategoryResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("deductions_categories").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return DeductionCategoryResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return DeductionCategoryResultFactory.UpdateFail();
        }

        return DeductionCategoryResultFactory.UpdateSuccess(new DeductionCategory());

    }

}
