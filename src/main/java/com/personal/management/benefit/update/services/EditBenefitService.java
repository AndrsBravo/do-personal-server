package com.personal.management.benefit.update.services;

import java.util.Optional;

import com.personal.management.benefit.entities.Benefit;
import com.personal.management.benefit.factories.BenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditBenefitService implements IEditService<Benefit> {

    private final Optional<DbClient> dbClient;

    public EditBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Benefit> edit(Query query) {

        if (dbClient.isEmpty()) {
            return BenefitResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("business_benefits").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return BenefitResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return BenefitResultFactory.UpdateFail();
        }

        return BenefitResultFactory.UpdateSuccess(new Benefit());

    }

}
