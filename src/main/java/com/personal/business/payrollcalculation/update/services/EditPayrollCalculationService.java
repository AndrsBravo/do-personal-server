package com.personal.business.payrollcalculation.update.services;

import java.util.Optional;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.business.payrollcalculation.factories.PayrollCalculationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollCalculationService implements IEditService<PayrollCalculation> {

    private final Optional<DbClient> dbClient;

    public EditPayrollCalculationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollCalculation> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollCalculationResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_calculations").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return PayrollCalculationResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollCalculationResultFactory.UpdateFail();
        }

        return PayrollCalculationResultFactory.UpdateSuccess(new PayrollCalculation());

    }

}
