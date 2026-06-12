package com.personal.business.benefitrate.create.services;

import java.util.Optional;

import com.personal.business.benefitrate.entities.BenefitRate;
import com.personal.business.benefitrate.factories.BenefitRateResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateBenefitRateService implements ICreateService<BenefitRate> {

    private final Optional<DbClient> dbClient;

    public CreateBenefitRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitRate> create(Query query) {
        if (dbClient.isEmpty()) {
            return BenefitRateResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("business_benefits_rates").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return BenefitRateResultFactory.CreateFail();
        }

        if (result == 0) {
            return BenefitRateResultFactory.CreateFail();
        }

        return BenefitRateResultFactory.CreateSuccess(new BenefitRate());

    }

}
