package com.personal.business.employeebenefitfeed.create.services;

import java.util.Optional;

import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.employeebenefitfeed.factories.EmployeeBenefitFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeBenefitFeedService implements ICreateService<EmployeeBenefitFeed> {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeBenefitFeed> create(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeBenefitFeedResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employee_benefits_feeds").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return EmployeeBenefitFeedResultFactory.CreateFail();
        }

        if (result == 0) {
            return EmployeeBenefitFeedResultFactory.CreateFail();
        }

        return EmployeeBenefitFeedResultFactory.CreateSuccess(new EmployeeBenefitFeed());

    }

}
