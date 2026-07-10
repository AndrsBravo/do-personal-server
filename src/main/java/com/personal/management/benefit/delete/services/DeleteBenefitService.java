package com.personal.management.benefit.delete.services;

import java.util.Optional;

import com.personal.management.benefit.entities.Benefit;
import com.personal.management.benefit.factories.BenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteBenefitService implements IDeleteService<Benefit> {

    private final Optional<DbClient> dbClient;

    public DeleteBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Benefit> delete(Query query) {
        if (dbClient.isEmpty()) {
            return BenefitResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("business_benefits").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return BenefitResultFactory.DeleteFail();
        }

        if (result == 0) {
            return BenefitResultFactory.DeleteFail();
        }

        return BenefitResultFactory.DeleteSuccess(new Benefit(query.getParams().get("id")));

    }

}
