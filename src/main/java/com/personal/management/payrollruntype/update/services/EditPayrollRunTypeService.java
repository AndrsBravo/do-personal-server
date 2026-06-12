package com.personal.management.payrollruntype.update.services;

import java.util.Optional;

import com.personal.management.payrollruntype.factories.PayrollRunTypeResultFactory;
import com.personal.management.shared.entities.TypeEntity;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollRunTypeService implements IEditService<TypeEntity> {

    private final Optional<DbClient> dbClient;

    public EditPayrollRunTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TypeEntity> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollRunTypeResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_runs_types").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de cliente " + e.getMessage());
            return PayrollRunTypeResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollRunTypeResultFactory.UpdateFail();
        }

        return PayrollRunTypeResultFactory.UpdateSuccess(new TypeEntity());

    }

}
