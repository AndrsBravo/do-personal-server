package com.personal.business.employeebenefit.delete.services;

import java.util.Optional;

import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.employeebenefit.factories.EmployeeBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeBenefitService implements IDeleteService<EmployeeBenefit> {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<EmployeeBenefit> delete(Query query) {
        if (dbClient.isEmpty()) {
            return EmployeeBenefitResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employee_benefits").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return EmployeeBenefitResultFactory.DeleteFail();
        }

        if (result == 0) {
            return EmployeeBenefitResultFactory.DeleteFail();
        }

        return EmployeeBenefitResultFactory.DeleteSuccess(new EmployeeBenefit(query.getParams().get("id")));

    }

}
