package com.personal.business.employeebenefit.create.services;

import java.util.Optional;

import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.employeebenefit.factories.EmployeeBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeBenefitService implements ICreateService<EmployeeBenefit> {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeBenefit> create(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeBenefitResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employee_benefits").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return EmployeeBenefitResultFactory.CreateFail();
        }

        if (result == 0) {
            return EmployeeBenefitResultFactory.CreateFail();
        }

        return EmployeeBenefitResultFactory.CreateSuccess(new EmployeeBenefit());

    }

}
