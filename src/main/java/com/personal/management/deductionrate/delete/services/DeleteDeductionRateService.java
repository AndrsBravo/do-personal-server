package com.personal.management.deductionrate.delete.services;

import java.util.Optional;

import com.personal.management.deductionrate.entities.DeductionRate;
import com.personal.management.deductionrate.factories.DeductionRateResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteDeductionRateService implements IDeleteService<DeductionRate> {

    private final Optional<DbClient> dbClient;

    public DeleteDeductionRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<DeductionRate> delete(Query query) {
        if (dbClient.isEmpty()) {
            return DeductionRateResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("business_deductions_rates").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return DeductionRateResultFactory.DeleteFail();
        }

        if (result == 0) {
            return DeductionRateResultFactory.DeleteFail();
        }

        return DeductionRateResultFactory.DeleteSuccess(new DeductionRate(query.getParams().get("id")));

    }

}
