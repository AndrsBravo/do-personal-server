package com.personal.management.benefitrate.update.services;

import java.util.Optional;

import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.management.benefitrate.factories.BenefitRateResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditBenefitRateService implements IEditService<BenefitRate> {

    private final Optional<DbClient> dbClient;

    public EditBenefitRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitRate> edit(Query query) {

        if (dbClient.isEmpty()) {
            return BenefitRateResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("business_benefits_rates").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return BenefitRateResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return BenefitRateResultFactory.UpdateFail();
        }

        return BenefitRateResultFactory.UpdateSuccess(new BenefitRate());

    }

}
