package com.personal.business.employeebenefitfeed.delete.services;

import java.util.Optional;

import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.employeebenefitfeed.factories.EmployeeBenefitFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeBenefitFeedService implements IDeleteService<EmployeeBenefitFeed> {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeBenefitFeed> delete(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeBenefitFeedResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employee_benefits_feeds").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return EmployeeBenefitFeedResultFactory.DeleteFail();
        }

        if (result == 0) {
            return EmployeeBenefitFeedResultFactory.DeleteFail();
        }

        return EmployeeBenefitFeedResultFactory.DeleteSuccess(new EmployeeBenefitFeed(query.getParams().get("id")));

    }

}
