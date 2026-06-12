package com.personal.management.payroll.delete.services;

import java.util.Optional;

import com.personal.management.payroll.entities.Payroll;
import com.personal.management.payroll.factories.PayrollResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollService implements IDeleteService<Payroll> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Payroll> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payrolls").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return PayrollResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollResultFactory.DeleteFail();
        }

        return PayrollResultFactory.DeleteSuccess(new Payroll(query.getParams().get("id")));

    }

}
