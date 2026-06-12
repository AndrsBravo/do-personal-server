package com.personal.business.payrollrunresult.update.services;

import java.util.Optional;

import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.business.payrollrunresult.factories.PayrollRunResultResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollRunResultService implements IEditService<PayrollRunResult> {

    private final Optional<DbClient> dbClient;

    public EditPayrollRunResultService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRunResult> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollRunResultResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_runs_results").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return PayrollRunResultResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollRunResultResultFactory.UpdateFail();
        }

        return PayrollRunResultResultFactory.UpdateSuccess(new PayrollRunResult());

    }

}
