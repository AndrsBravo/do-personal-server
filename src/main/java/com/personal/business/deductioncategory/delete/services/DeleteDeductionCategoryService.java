package com.personal.business.deductioncategory.delete.services;

import java.util.Optional;

import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.business.deductioncategory.factories.DeductionCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteDeductionCategoryService implements IDeleteService<DeductionCategory> {

    private final Optional<DbClient> dbClient;

    public DeleteDeductionCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<DeductionCategory> delete(Query query) {
        if (dbClient.isEmpty()) {
            return DeductionCategoryResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("deductions_categories").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return DeductionCategoryResultFactory.DeleteFail();
        }

        if (result == 0) {
            return DeductionCategoryResultFactory.DeleteFail();
        }

        return DeductionCategoryResultFactory.DeleteSuccess(new DeductionCategory(query.getParams().get("id")));

    }

}
