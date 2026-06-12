package com.personal.business.payrollcalculationresult.delete.services;

import java.util.Optional;

import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.business.payrollcalculationresult.factories.PayrollCalculationResultResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollCalculationResultService implements IDeleteService<PayrollCalculationResult> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollCalculationResultService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollCalculationResult> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollCalculationResultResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_calculations_results").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return PayrollCalculationResultResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollCalculationResultResultFactory.DeleteFail();
        }

        return PayrollCalculationResultResultFactory.DeleteSuccess(new PayrollCalculationResult(query.getParams().get("id")));

    }

}
