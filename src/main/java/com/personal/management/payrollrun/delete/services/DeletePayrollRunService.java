package com.personal.management.payrollrun.delete.services;

import java.util.Optional;

import com.personal.management.payrollrun.entities.PayrollRun;
import com.personal.management.payrollrun.factories.PayrollRunResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollRunService implements IDeleteService<PayrollRun> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollRunService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRun> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_runs").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return PayrollRunResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollRunResultFactory.DeleteFail();
        }

        return PayrollRunResultFactory.DeleteSuccess(new PayrollRun(query.getParams().get("id")));

    }

}
