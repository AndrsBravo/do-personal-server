package com.personal.management.payrolldeduction.update.services;

import java.util.Optional;

import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.management.payrolldeduction.factories.PayrollDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollDeductionService implements IEditService<PayrollDeduction> {

    private final Optional<DbClient> dbClient;

    public EditPayrollDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollDeduction> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollDeductionResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_deductions").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return PayrollDeductionResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollDeductionResultFactory.UpdateFail();
        }

        return PayrollDeductionResultFactory.UpdateSuccess(new PayrollDeduction());

    }

}
