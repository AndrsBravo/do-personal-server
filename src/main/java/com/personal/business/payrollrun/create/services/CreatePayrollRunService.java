package com.personal.business.payrollrun.create.services;

import java.util.Optional;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.business.payrollrun.factories.PayrollRunResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollRunService implements ICreateService<PayrollRun> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollRunService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRun> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_runs").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return PayrollRunResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollRunResultFactory.CreateFail();
        }

        return PayrollRunResultFactory.CreateSuccess(new PayrollRun());

    }

}
