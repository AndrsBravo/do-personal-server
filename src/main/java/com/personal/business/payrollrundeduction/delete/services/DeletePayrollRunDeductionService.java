package com.personal.business.payrollrundeduction.delete.services;

import java.util.Optional;

import com.personal.business.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.business.payrollrundeduction.factories.PayrollRunDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollRunDeductionService implements IDeleteService<PayrollRunDeduction> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollRunDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRunDeduction> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunDeductionResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_runs_deductions").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return PayrollRunDeductionResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollRunDeductionResultFactory.DeleteFail();
        }

        return PayrollRunDeductionResultFactory.DeleteSuccess(new PayrollRunDeduction(query.getParams().get("id")));

    }

}
