package com.personal.business.benefitcategory.create.services;

import java.util.Optional;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.business.benefitcategory.factories.BenefitCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateBenefitCategoryService implements ICreateService<BenefitCategory> {

    private final Optional<DbClient> dbClient;

    public CreateBenefitCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitCategory> create(Query query) {
        if (dbClient.isEmpty()) {
            return BenefitCategoryResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("benefit_categories").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return BenefitCategoryResultFactory.CreateFail();
        }

        if (result == 0) {
            return BenefitCategoryResultFactory.CreateFail();
        }

        return BenefitCategoryResultFactory.CreateSuccess(new BenefitCategory());

    }

}
