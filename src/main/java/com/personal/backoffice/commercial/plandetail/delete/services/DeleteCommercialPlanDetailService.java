package com.personal.backoffice.commercial.plandetail.delete.services;

import java.util.Optional;

import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.backoffice.commercial.plandetail.factories.CommercialPlanDetailResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteCommercialPlanDetailService implements IDeleteService<CommercialPlanDetail> {

    private final Optional<DbClient> dbClient;

    public DeleteCommercialPlanDetailService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<CommercialPlanDetail> delete(Query query) {
        if (dbClient.isEmpty()) {
            return CommercialPlanDetailResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("commercial_plan_details").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return CommercialPlanDetailResultFactory.DeleteFail();
        }

        if (result == 0) {
            return CommercialPlanDetailResultFactory.DeleteFail();
        }

        return CommercialPlanDetailResultFactory.DeleteSuccess(new CommercialPlanDetail(query.getParams().get("id")));

    }

}
