package com.personal.management.financecategory.delete.services;

import java.util.Optional;

import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.management.financecategory.factories.FinanceCategoryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteFinanceCategoryService implements IDeleteService<FinanceCategory> {

    private final Optional<DbClient> dbClient;

    public DeleteFinanceCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<FinanceCategory> delete(Query query) {
        if (dbClient.isEmpty()) {
            return FinanceCategoryResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("finance_categories").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return FinanceCategoryResultFactory.DeleteFail();
        }

        if (result == 0) {
            return FinanceCategoryResultFactory.DeleteFail();
        }

        return FinanceCategoryResultFactory.DeleteSuccess(new FinanceCategory(query.getParams().get("id")));

    }

}
