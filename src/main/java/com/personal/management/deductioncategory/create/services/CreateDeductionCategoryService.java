package com.personal.management.deductioncategory.create.services;

import java.util.Optional;

import com.personal.management.deductioncategory.entities.DeductionCategory;
import com.personal.management.deductioncategory.factories.DeductionCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateDeductionCategoryService implements ICreateService<DeductionCategory> {

    private final Optional<DbClient> dbClient;

    public CreateDeductionCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<DeductionCategory> create(Query query) {
        if (dbClient.isEmpty()) {
            return DeductionCategoryResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("deductions_categories").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return DeductionCategoryResultFactory.CreateFail();
        }

        if (result == 0) {
            return DeductionCategoryResultFactory.CreateFail();
        }

        return DeductionCategoryResultFactory.CreateSuccess(new DeductionCategory());

    }

}
