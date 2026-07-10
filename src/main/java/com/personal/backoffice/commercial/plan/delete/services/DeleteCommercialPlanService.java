package com.personal.backoffice.commercial.plan.delete.services;

import java.util.Optional;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plan.factories.CommercialPlanResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteCommercialPlanService implements IDeleteService<CommercialPlan> {

    private final Optional<DbClient> dbClient;

    public DeleteCommercialPlanService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<CommercialPlan> delete(Query query) {
        if (dbClient.isEmpty()) {
            return CommercialPlanResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("commercial_plan").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return CommercialPlanResultFactory.DeleteFail();
        }

        if (result == 0) {
            return CommercialPlanResultFactory.DeleteFail();
        }

        return CommercialPlanResultFactory.DeleteSuccess(new CommercialPlan(query.getParams().get("id")));

    }

}
