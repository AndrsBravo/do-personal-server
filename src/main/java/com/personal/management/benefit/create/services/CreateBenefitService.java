package com.personal.management.benefit.create.services;

import java.util.Optional;

import com.personal.management.benefit.entities.Benefit;
import com.personal.management.benefit.factories.BenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateBenefitService implements ICreateService<Benefit> {

    private final Optional<DbClient> dbClient;

    public CreateBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Benefit> create(Query query) {
        if (dbClient.isEmpty()) {
            return BenefitResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("business_benefits").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return BenefitResultFactory.CreateFail();
        }

        if (result == 0) {
            return BenefitResultFactory.CreateFail();
        }

        return BenefitResultFactory.CreateSuccess(new Benefit());

    }

}
