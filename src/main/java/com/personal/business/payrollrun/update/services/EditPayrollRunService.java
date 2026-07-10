package com.personal.business.payrollrun.update.services;

import java.util.Optional;

import com.personal.business.payrollrun.entities.PayrollRun;
import com.personal.business.payrollrun.factories.PayrollRunResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollRunService implements IEditService<PayrollRun> {

    private final Optional<DbClient> dbClient;

    public EditPayrollRunService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRun> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollRunResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_runs").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return PayrollRunResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollRunResultFactory.UpdateFail();
        }

        return PayrollRunResultFactory.UpdateSuccess(new PayrollRun());

    }

}
