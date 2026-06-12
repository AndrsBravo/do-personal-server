package com.personal.business.payrollrunresult.delete.services;

import java.util.Optional;

import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.business.payrollrunresult.factories.PayrollRunResultResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollRunResultService implements IDeleteService<PayrollRunResult> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollRunResultService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRunResult> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunResultResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_runs_results").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return PayrollRunResultResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollRunResultResultFactory.DeleteFail();
        }

        return PayrollRunResultResultFactory.DeleteSuccess(new PayrollRunResult(query.getParams().get("id")));

    }

}
