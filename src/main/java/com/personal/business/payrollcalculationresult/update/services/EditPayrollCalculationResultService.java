package com.personal.business.payrollcalculationresult.update.services;

import java.util.Optional;

import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.business.payrollcalculationresult.factories.PayrollCalculationResultResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollCalculationResultService implements IEditService<PayrollCalculationResult> {

    private final Optional<DbClient> dbClient;

    public EditPayrollCalculationResultService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollCalculationResult> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollCalculationResultResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_calculations_results").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return PayrollCalculationResultResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollCalculationResultResultFactory.UpdateFail();
        }

        return PayrollCalculationResultResultFactory.UpdateSuccess(new PayrollCalculationResult());

    }

}
