package com.personal.business.payrollrundeduction.update.services;

import java.util.Optional;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.business.payrollrundeduction.factories.PayrollRunDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollRunDeductionService implements IEditService<PayrollRunDeduction> {

    private final Optional<DbClient> dbClient;

    public EditPayrollRunDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRunDeduction> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollRunDeductionResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_runs_deductions").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return PayrollRunDeductionResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollRunDeductionResultFactory.UpdateFail();
        }

        return PayrollRunDeductionResultFactory.UpdateSuccess(new PayrollRunDeduction());

    }

}
