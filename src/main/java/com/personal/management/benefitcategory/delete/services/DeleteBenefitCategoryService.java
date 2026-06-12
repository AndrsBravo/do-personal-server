package com.personal.management.benefitcategory.delete.services;

import java.util.Optional;

import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.management.benefitcategory.factories.BenefitCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

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
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return BenefitCategoryResultFactory.DeleteFail();
        }

        if (result == 0) {
            return BenefitCategoryResultFactory.DeleteFail();
        }

        return BenefitCategoryResultFactory.DeleteSuccess(new BenefitCategory(query.getParams().get("id")));

    }

}
