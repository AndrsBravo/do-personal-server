package com.personal.backoffice.commercial.plandetail.update.services;

import java.util.Optional;

import com.personal.backoffice.commercial.plandetail.entities.CommercialPlanDetail;
import com.personal.backoffice.commercial.plandetail.factories.CommercialPlanDetailResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditCommercialPlanDetailService implements IEditService<CommercialPlanDetail> {

    private final Optional<DbClient> dbClient;

    public EditCommercialPlanDetailService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<CommercialPlanDetail> edit(Query query) {

        if (dbClient.isEmpty()) {
            return CommercialPlanDetailResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("commercial_plan_details").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return CommercialPlanDetailResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return CommercialPlanDetailResultFactory.UpdateFail();
        }

        return CommercialPlanDetailResultFactory.UpdateSuccess(new CommercialPlanDetail());

    }

}
