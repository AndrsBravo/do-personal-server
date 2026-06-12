package com.personal.business.payroll.update.services;

import java.util.Optional;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payroll.factories.PayrollResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollService implements IEditService<Payroll> {

    private final Optional<DbClient> dbClient;

    public EditPayrollService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Payroll> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payrolls").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return PayrollResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollResultFactory.UpdateFail();
        }

        return PayrollResultFactory.UpdateSuccess(new Payroll());

    }

}
