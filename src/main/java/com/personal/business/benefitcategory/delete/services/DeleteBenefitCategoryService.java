package com.personal.business.benefitcategory.delete.services;

import java.util.Optional;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.business.benefitcategory.factories.BenefitCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteBenefitCategoryService implements IDeleteService<BenefitCategory> {

    private final Optional<DbClient> dbClient;

    public DeleteBenefitCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitCategory> delete(Query query) {
        if (dbClient.isEmpty()) {
            return BenefitCategoryResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("benefit_categories").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return BenefitCategoryResultFactory.DeleteFail();
        }

        if (result == 0) {
            return BenefitCategoryResultFactory.DeleteFail();
        }

        return BenefitCategoryResultFactory.DeleteSuccess(new BenefitCategory(query.getParams().get("id")));

    }

}
