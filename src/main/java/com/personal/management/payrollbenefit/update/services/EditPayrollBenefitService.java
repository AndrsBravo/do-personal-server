package com.personal.management.payrollbenefit.update.services;

import java.util.Optional;

import com.personal.management.payrollbenefit.entities.PayrollBenefit;
import com.personal.management.payrollbenefit.factories.PayrollBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditPayrollBenefitService implements IEditService<PayrollBenefit> {

    private final Optional<DbClient> dbClient;

    public EditPayrollBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<PayrollBenefit> edit(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollBenefitResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_benefits").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return PayrollBenefitResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return PayrollBenefitResultFactory.UpdateFail();
        }

        return PayrollBenefitResultFactory.UpdateSuccess(new PayrollBenefit());

    }

}
