package com.personal.management.deduction.create.services;

import java.util.Optional;

import com.personal.management.deduction.entities.Deduction;
import com.personal.management.deduction.factories.DeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateDeductionService implements ICreateService<Deduction> {

    private final Optional<DbClient> dbClient;

    public CreateDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Deduction> create(Query query) {
        if (dbClient.isEmpty()) {
            return DeductionResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("business_deductions").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return DeductionResultFactory.CreateFail();
        }

        if (result == 0) {
            return DeductionResultFactory.CreateFail();
        }

        return DeductionResultFactory.CreateSuccess(new Deduction());

    }

}
