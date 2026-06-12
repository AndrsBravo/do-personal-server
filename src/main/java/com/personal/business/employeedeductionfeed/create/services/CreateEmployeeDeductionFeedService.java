package com.personal.business.employeedeductionfeed.create.services;

import java.util.Optional;

import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.factories.EmployeeDeductionFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeDeductionFeedService implements ICreateService<EmployeeDeductionFeed> {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeDeductionFeed> create(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeDeductionFeedResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employee_deductions_feeds").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return EmployeeDeductionFeedResultFactory.CreateFail();
        }

        if (result == 0) {
            return EmployeeDeductionFeedResultFactory.CreateFail();
        }

        return EmployeeDeductionFeedResultFactory.CreateSuccess(new EmployeeDeductionFeed());

    }

}
