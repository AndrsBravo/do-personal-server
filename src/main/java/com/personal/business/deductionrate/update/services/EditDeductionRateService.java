package com.personal.business.deductionrate.update.services;

import java.util.Optional;

import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.business.deductionrate.factories.DeductionRateResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditDeductionRateService implements IEditService<DeductionRate> {

    private final Optional<DbClient> dbClient;

    public EditDeductionRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<DeductionRate> edit(Query query) {

        if (dbClient.isEmpty()) {
            return DeductionRateResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("business_deductions_rates").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return DeductionRateResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return DeductionRateResultFactory.UpdateFail();
        }

        return DeductionRateResultFactory.UpdateSuccess(new DeductionRate());

    }

}
