package com.personal.business.employee.update.services;

import java.util.Optional;

import com.personal.business.employee.entities.Employee;
import com.personal.business.employee.factories.EmployeeResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditEmployeeService implements IEditService<Employee> {

    private final Optional<DbClient> dbClient;

    public EditEmployeeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Employee> edit(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("employees").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return EmployeeResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return EmployeeResultFactory.UpdateFail();
        }

        return EmployeeResultFactory.UpdateSuccess(new Employee());

    }

}
