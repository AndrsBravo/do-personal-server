package com.personal.business.deductionrate.create.services;

import java.util.Optional;

import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.business.deductionrate.factories.DeductionRateResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateDeductionRateService implements ICreateService<DeductionRate> {

    private final Optional<DbClient> dbClient;

    public CreateDeductionRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<DeductionRate> create(Query query) {
        if (dbClient.isEmpty()) {
            return DeductionRateResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("business_deductions_rates").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return DeductionRateResultFactory.CreateFail();
        }

        if (result == 0) {
            return DeductionRateResultFactory.CreateFail();
        }

        return DeductionRateResultFactory.CreateSuccess(new DeductionRate());

    }

}
