package com.personal.business.benefitcategory.update.services;

import java.util.Optional;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.business.benefitcategory.factories.BenefitCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditBenefitCategoryService implements IEditService<BenefitCategory> {

    private final Optional<DbClient> dbClient;

    public EditBenefitCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitCategory> edit(Query query) {

        if (dbClient.isEmpty()) {
            return BenefitCategoryResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("benefit_categories").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return BenefitCategoryResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return BenefitCategoryResultFactory.UpdateFail();
        }

        return BenefitCategoryResultFactory.UpdateSuccess(new BenefitCategory());

    }

}
