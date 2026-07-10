package com.personal.business.employeedeductionfeed.delete.services;

import java.util.Optional;

import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.factories.EmployeeDeductionFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeDeductionFeedService implements IDeleteService<EmployeeDeductionFeed> {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeDeductionFeed> delete(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeDeductionFeedResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employee_deductions_feeds").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return EmployeeDeductionFeedResultFactory.DeleteFail();
        }

        if (result == 0) {
            return EmployeeDeductionFeedResultFactory.DeleteFail();
        }

        return EmployeeDeductionFeedResultFactory.DeleteSuccess(new EmployeeDeductionFeed(query.getParams().get("id")));

    }

}
