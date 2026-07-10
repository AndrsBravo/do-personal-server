package com.personal.business.employee.delete.services;

import java.util.Optional;

import com.personal.business.employee.entities.Employee;
import com.personal.business.employee.factories.EmployeeResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeService implements IDeleteService<Employee> {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Employee> delete(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employees").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return EmployeeResultFactory.DeleteFail();
        }

        if (result == 0) {
            return EmployeeResultFactory.DeleteFail();
        }

        return EmployeeResultFactory.DeleteSuccess(new Employee(query.getParams().get("id")));

    }

}
