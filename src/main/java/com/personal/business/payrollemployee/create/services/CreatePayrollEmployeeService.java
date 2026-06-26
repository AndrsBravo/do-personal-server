package com.personal.business.payrollemployee.create.services;

import java.util.Optional;

import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.business.payrollemployee.factories.PayrollEmployeeResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollEmployeeService implements ICreateService<PayrollEmployee> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollEmployeeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollEmployee> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollEmployeeResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_employee").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return PayrollEmployeeResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollEmployeeResultFactory.CreateFail();
        }

        return PayrollEmployeeResultFactory.CreateSuccess(new PayrollEmployee());

    }

}
