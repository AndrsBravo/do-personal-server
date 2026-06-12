package com.personal.management.payrollrundeduction.create.services;

import java.util.Optional;

import com.personal.management.payrollrundeduction.entities.PayrollRunDeduction;
import com.personal.management.payrollrundeduction.factories.PayrollRunDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollRunDeductionService implements ICreateService<PayrollRunDeduction> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollRunDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollRunDeduction> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunDeductionResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_runs_deductions").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return PayrollRunDeductionResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollRunDeductionResultFactory.CreateFail();
        }

        return PayrollRunDeductionResultFactory.CreateSuccess(new PayrollRunDeduction());

    }

}
