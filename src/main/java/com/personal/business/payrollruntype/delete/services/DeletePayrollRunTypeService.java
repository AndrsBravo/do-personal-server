package com.personal.business.payrollruntype.delete.services;

import java.util.Optional;

import com.personal.business.payrollruntype.factories.PayrollRunTypeResultFactory;
import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeletePayrollRunTypeService implements IDeleteService<TypeEntity> {

    private final Optional<DbClient> dbClient;

    public DeletePayrollRunTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TypeEntity> delete(Query query) {
        if (dbClient.isEmpty()) {
            return PayrollRunTypeResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_runs_types").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de cliente " + e.getMessage());
            return PayrollRunTypeResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollRunTypeResultFactory.DeleteFail();
        }

        return PayrollRunTypeResultFactory.DeleteSuccess(new TypeEntity(query.getParams().get("id")));

    }

}
