package com.personal.business.employeededuction.delete.services;

import java.util.Optional;

import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.employeededuction.factories.EmployeeDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeDeductionService implements IDeleteService<EmployeeDeduction> {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeDeduction> delete(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeDeductionResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employee_deductions").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return EmployeeDeductionResultFactory.DeleteFail();
        }

        if (result == 0) {
            return EmployeeDeductionResultFactory.DeleteFail();
        }

        return EmployeeDeductionResultFactory.DeleteSuccess(new EmployeeDeduction(query.getParams().get("id")));

    }

}
