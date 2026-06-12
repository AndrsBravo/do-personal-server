package com.personal.backoffice.commercial.plandetail.create.services;

import java.util.Optional;

import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.backoffice.commercial.plandetail.factories.CommercialPlanDetailResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateCommercialPlanDetailService implements ICreateService<CommercialPlanDetail> {

    private final Optional<DbClient> dbClient;

    public CreateCommercialPlanDetailService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<CommercialPlanDetail> create(Query query) {
        if (dbClient.isEmpty()) {
            return CommercialPlanDetailResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("commercial_plan_details").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return CommercialPlanDetailResultFactory.CreateFail();
        }

        if (result == 0) {
            return CommercialPlanDetailResultFactory.CreateFail();
        }

        return CommercialPlanDetailResultFactory.CreateSuccess(new CommercialPlanDetail());

    }

}
