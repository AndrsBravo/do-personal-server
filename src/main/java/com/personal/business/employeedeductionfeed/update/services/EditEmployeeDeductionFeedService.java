package com.personal.business.employeedeductionfeed.update.services;

import java.util.Optional;

import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.factories.EmployeeDeductionFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditEmployeeDeductionFeedService implements IEditService<EmployeeDeductionFeed> {

    private final Optional<DbClient> dbClient;

    public EditEmployeeDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeDeductionFeed> edit(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeDeductionFeedResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("employee_deductions_feeds").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return EmployeeDeductionFeedResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return EmployeeDeductionFeedResultFactory.UpdateFail();
        }

        return EmployeeDeductionFeedResultFactory.UpdateSuccess(new EmployeeDeductionFeed());

    }

}
