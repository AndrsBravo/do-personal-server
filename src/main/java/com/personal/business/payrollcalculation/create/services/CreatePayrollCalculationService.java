package com.personal.business.payrollcalculation.create.services;

import java.util.Optional;

import com.personal.business.payrollcalculation.entities.PayrollCalculation;
import com.personal.business.payrollcalculation.factories.PayrollCalculationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollCalculationService implements ICreateService<PayrollCalculation> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollCalculationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollCalculation> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollCalculationResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_calculations").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return PayrollCalculationResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollCalculationResultFactory.CreateFail();
        }

        return PayrollCalculationResultFactory.CreateSuccess(new PayrollCalculation());

    }

}
