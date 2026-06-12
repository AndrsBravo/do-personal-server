package com.personal.business.payrollruntype.create.services;

import java.util.Optional;

import com.personal.business.payrollruntype.factories.PayrollRunTypeResultFactory;
import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreatePayrollRunTypeService implements ICreateService<TypeEntity> {

    private final Optional<DbClient> dbClient;

    public CreatePayrollRunTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TypeEntity> create(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunTypeResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_runs_types").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de cliente " + e.getMessage());
            return PayrollRunTypeResultFactory.CreateFail();
        }

        if (result == 0) {
            return PayrollRunTypeResultFactory.CreateFail();
        }

        return PayrollRunTypeResultFactory.CreateSuccess(new TypeEntity());

    }

}
