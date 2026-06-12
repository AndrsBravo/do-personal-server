package com.personal.management.payrollbenefit.delete.routes;

import com.personal.management.payrollbenefit.delete.process.DeletePayrollBenefitProcessExecutor;
import com.personal.management.payrollbenefit.entities.PayrollBenefit;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollBenefitHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollBenefit = new PayrollBenefit(id);

        var deletePayrollBenefit = DeletePayrollBenefitProcessExecutor.builder()
                .init(payrollBenefit)
                .execute();

        switch (deletePayrollBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollBenefit.getInitObject());
        }
    }

}
