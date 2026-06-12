package com.personal.business.payrollcalculation.delete.services;

import java.util.Optional;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.business.payrollcalculation.factories.PayrollCalculationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollCalculationService implements IDeleteService<PayrollCalculation> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollCalculationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollCalculation> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollCalculationResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_calculations").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return PayrollCalculationResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollCalculationResultFactory.DeleteFail();
        }

        return PayrollCalculationResultFactory.DeleteSuccess(new PayrollCalculation(query.getParams().get("id")));

    }

}
