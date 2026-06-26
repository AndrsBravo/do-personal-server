package com.personal.business.payrollrunresult.create.services;

import java.util.Optional;

import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.business.payrollrunresult.factories.PayrollRunResultResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollRunResultService implements ICreateService<PayrollRunResult> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollRunResultService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRunResult> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunResultResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_runs_results").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return PayrollRunResultResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollRunResultResultFactory.CreateFail();
        }

        return PayrollRunResultResultFactory.CreateSuccess(new PayrollRunResult());

    }

}
