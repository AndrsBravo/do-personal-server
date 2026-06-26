package com.personal.management.payrollrunbenefit.delete.services;

import java.util.Optional;

import com.personal.management.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.management.payrollrunbenefit.factories.PayrollRunBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollRunBenefitService implements IDeleteService<PayrollRunBenefit> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollRunBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRunBenefit> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunBenefitResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_runs_benefits").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return PayrollRunBenefitResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollRunBenefitResultFactory.DeleteFail();
        }

        return PayrollRunBenefitResultFactory.DeleteSuccess(new PayrollRunBenefit(query.getParams().get("id")));

    }

}
