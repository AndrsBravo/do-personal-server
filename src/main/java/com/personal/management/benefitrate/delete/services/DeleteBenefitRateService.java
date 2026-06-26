package com.personal.management.benefitrate.delete.services;

import java.util.Optional;

import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.management.benefitrate.factories.BenefitRateResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteBenefitRateService implements IDeleteService<BenefitRate> {

    private final Optional<DbClient> dbClient;

    public DeleteBenefitRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitRate> delete(Query query) {
        if (dbClient.isEmpty()) {
            return BenefitRateResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("business_benefits_rates").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return BenefitRateResultFactory.DeleteFail();
        }

        if (result == 0) {
            return BenefitRateResultFactory.DeleteFail();
        }

        return BenefitRateResultFactory.DeleteSuccess(new BenefitRate(query.getParams().get("id")));

    }

}
