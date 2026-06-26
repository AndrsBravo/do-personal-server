package com.personal.business.deduction.delete.services;

import java.util.Optional;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.deduction.factories.DeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteDeductionService implements IDeleteService<Deduction> {

    private final Optional<DbClient> dbClient;

    public DeleteDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Deduction> delete(Query query) {
        if (dbClient.isEmpty()) {
            return DeductionResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("business_deductions").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return DeductionResultFactory.DeleteFail();
        }

        if (result == 0) {
            return DeductionResultFactory.DeleteFail();
        }

        return DeductionResultFactory.DeleteSuccess(new Deduction(query.getParams().get("id")));

    }

}
