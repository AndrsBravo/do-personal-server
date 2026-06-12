package com.personal.business.employeededuction.create.services;

import java.util.Optional;

import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.employeededuction.factories.EmployeeDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeDeductionService implements ICreateService<EmployeeDeduction> {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeDeduction> create(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeDeductionResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employee_deductions").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return EmployeeDeductionResultFactory.CreateFail();
        }

        if (result == 0) {
            return EmployeeDeductionResultFactory.CreateFail();
        }

        return EmployeeDeductionResultFactory.CreateSuccess(new EmployeeDeduction());

    }

}
