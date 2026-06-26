package com.personal.business.payrollemployee.delete.services;

import java.util.Optional;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.business.payrollemployee.factories.PayrollEmployeeResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollEmployeeService implements IDeleteService<PayrollEmployee> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollEmployeeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollEmployee> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollEmployeeResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_employee").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return PayrollEmployeeResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollEmployeeResultFactory.DeleteFail();
        }

        return PayrollEmployeeResultFactory.DeleteSuccess(new PayrollEmployee(query.getParams().get("id")));

    }

}
