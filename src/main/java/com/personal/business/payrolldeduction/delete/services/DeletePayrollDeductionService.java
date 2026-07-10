package com.personal.business.payrolldeduction.delete.services;

import java.util.Optional;

import com.personal.business.payrolldeduction.entities.PayrollDeduction;
import com.personal.business.payrolldeduction.factories.PayrollDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

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

            return PayrollDeductionResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollDeductionResultFactory.DeleteFail();
        }

        return PayrollDeductionResultFactory.DeleteSuccess(new PayrollDeduction(query.getParams().get("id")));

    }

}
