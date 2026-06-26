package com.personal.backoffice.commercial.plan.create.services;

import java.util.Optional;

import com.personal.backoffice.commercial.plan.entities.CommercialPlan;
import com.personal.backoffice.commercial.plan.factories.CommercialPlanResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateCommercialPlanService implements ICreateService<CommercialPlan> {

    private final Optional<DbClient> dbClient;

    public CreateCommercialPlanService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<CommercialPlan> create(Query query) {
        if (dbClient.isEmpty()) {
            return CommercialPlanResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("commercial_plan").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return CommercialPlanResultFactory.CreateFail();
        }

        if (result == 0) {
            return CommercialPlanResultFactory.CreateFail();
        }

        return CommercialPlanResultFactory.CreateSuccess(new CommercialPlan());

    }

}
