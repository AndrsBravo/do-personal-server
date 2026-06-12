package com.personal.business.payrollrunbenefit.create.services;

import java.util.Optional;

import com.personal.business.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.business.payrollrunbenefit.factories.PayrollRunBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollRunBenefitService implements ICreateService<PayrollRunBenefit> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollRunBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRunBenefit> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunBenefitResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_runs_benefits").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return PayrollRunBenefitResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollRunBenefitResultFactory.CreateFail();
        }

        return PayrollRunBenefitResultFactory.CreateSuccess(new PayrollRunBenefit());

    }

}
