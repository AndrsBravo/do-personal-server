package com.personal.business.employeescale.delete.services;

import java.util.Optional;

import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.business.employeescale.factories.EmployeeScaleResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeScaleService implements IDeleteService<EmployeeScale> {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeScaleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeScale> delete(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeScaleResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employee_scale").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return EmployeeScaleResultFactory.DeleteFail();
        }

        if (result == 0) {
            return EmployeeScaleResultFactory.DeleteFail();
        }

        return EmployeeScaleResultFactory.DeleteSuccess(new EmployeeScale(query.getParams().get("id")));

    }

}
