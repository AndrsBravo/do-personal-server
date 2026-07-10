package com.personal.management.payrollbenefit.delete.services;

import java.util.Optional;

import com.personal.management.payrollbenefit.entities.PayrollBenefit;
import com.personal.management.payrollbenefit.factories.PayrollBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollBenefitService implements IDeleteService<PayrollBenefit> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollBenefit> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollBenefitResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_benefits").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return PayrollBenefitResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollBenefitResultFactory.DeleteFail();
        }

        return PayrollBenefitResultFactory.DeleteSuccess(new PayrollBenefit(query.getParams().get("id")));

    }

}
