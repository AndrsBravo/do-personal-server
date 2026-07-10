package com.personal.business.employeebenefitfeed.update.services;

import java.util.Optional;

import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.employeebenefitfeed.factories.EmployeeBenefitFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditEmployeeBenefitFeedService implements IEditService<EmployeeBenefitFeed> {

    private final Optional<DbClient> dbClient;

    public EditEmployeeBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeBenefitFeed> edit(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeBenefitFeedResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("employee_benefits_feeds").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return EmployeeBenefitFeedResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return EmployeeBenefitFeedResultFactory.UpdateFail();
        }

        return EmployeeBenefitFeedResultFactory.UpdateSuccess(new EmployeeBenefitFeed());

    }

}
