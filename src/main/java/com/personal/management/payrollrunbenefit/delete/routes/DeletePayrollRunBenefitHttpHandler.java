package com.personal.management.payrollrunbenefit.delete.routes;

import com.personal.management.payrollrunbenefit.delete.process.DeletePayrollRunBenefitProcessExecutor;
import com.personal.management.payrollrunbenefit.entities.PayrollRunBenefit;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollRunBenefitHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollRunBenefit = new PayrollRunBenefit(id);

        var deletePayrollRunBenefit = DeletePayrollRunBenefitProcessExecutor.builder()
                .init(payrollRunBenefit)
                .execute();

        switch (deletePayrollRunBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollRunBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollRunBenefit.getInitObject());
        }
    }

}
