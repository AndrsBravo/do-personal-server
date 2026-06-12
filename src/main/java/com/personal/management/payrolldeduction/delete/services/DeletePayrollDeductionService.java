package com.personal.management.payrolldeduction.delete.services;

import java.util.Optional;

import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.management.payrolldeduction.factories.PayrollDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollDeductionService implements IDeleteService<PayrollDeduction> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollDeduction> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollDeductionResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_deductions").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return PayrollDeductionResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollDeductionResultFactory.DeleteFail();
        }

        return PayrollDeductionResultFactory.DeleteSuccess(new PayrollDeduction(query.getParams().get("id")));

    }

}
