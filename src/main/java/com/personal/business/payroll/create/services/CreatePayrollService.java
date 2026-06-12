package com.personal.business.payroll.create.services;

import java.util.Optional;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payroll.factories.PayrollResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollService implements ICreateService<Payroll> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Payroll> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payrolls").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return PayrollResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollResultFactory.CreateFail();
        }

        return PayrollResultFactory.CreateSuccess(new Payroll());

    }

}
