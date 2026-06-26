package com.personal.business.financecategory.create.services;

import java.util.Optional;

import com.personal.business.financecategory.entities.FinanceCategory;
import com.personal.business.financecategory.factories.FinanceCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateFinanceCategoryService implements ICreateService<FinanceCategory> {

    private final Optional<DbClient> dbClient;

    public CreateFinanceCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<FinanceCategory> create(Query query) {
        if (dbClient.isEmpty()) {
            return FinanceCategoryResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("finance_categories").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return FinanceCategoryResultFactory.CreateFail();
        }

        if (result == 0) {
            return FinanceCategoryResultFactory.CreateFail();
        }

        return FinanceCategoryResultFactory.CreateSuccess(new FinanceCategory());

    }

}
