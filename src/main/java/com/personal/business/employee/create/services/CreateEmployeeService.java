package com.personal.business.employee.create.services;

import java.util.Optional;

import com.personal.business.employee.entities.Employee;
import com.personal.business.employee.factories.EmployeeResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeService implements ICreateService<Employee> {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Employee> create(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employees").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return EmployeeResultFactory.CreateFail();
        }

        if (result == 0) {
            return EmployeeResultFactory.CreateFail();
        }

        return EmployeeResultFactory.CreateSuccess(new Employee());

    }

}
