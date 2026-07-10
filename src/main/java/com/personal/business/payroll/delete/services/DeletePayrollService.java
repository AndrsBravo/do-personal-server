package com.personal.business.payroll.delete.services;

import java.util.Optional;

import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payroll.factories.PayrollResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

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

            return PayrollResultFactory.DeleteFail();
        }

        if (result == 0) {
            return PayrollResultFactory.DeleteFail();
        }

        return PayrollResultFactory.DeleteSuccess(new Payroll(query.getParams().get("id")));

    }

}
