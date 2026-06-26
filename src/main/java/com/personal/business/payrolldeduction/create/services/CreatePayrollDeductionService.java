package com.personal.business.payrolldeduction.create.services;

import java.util.Optional;

import com.personal.business.payrolldeduction.entities.PayrollDeduction;
import com.personal.business.payrolldeduction.factories.PayrollDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollDeductionService implements ICreateService<PayrollDeduction> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollDeduction> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollDeductionResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_deductions").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return PayrollDeductionResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollDeductionResultFactory.CreateFail();
        }

        return PayrollDeductionResultFactory.CreateSuccess(new PayrollDeduction());

    }

}
