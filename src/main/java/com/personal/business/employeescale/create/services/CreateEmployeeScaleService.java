package com.personal.business.employeescale.create.services;

import java.util.Optional;

import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.business.employeescale.factories.EmployeeScaleResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeScaleService implements ICreateService<EmployeeScale> {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeScaleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeScale> create(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeScaleResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employee_scale").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return EmployeeScaleResultFactory.CreateFail();
        }

        if (result == 0) {
            return EmployeeScaleResultFactory.CreateFail();
        }

        return EmployeeScaleResultFactory.CreateSuccess(new EmployeeScale());

    }

}
