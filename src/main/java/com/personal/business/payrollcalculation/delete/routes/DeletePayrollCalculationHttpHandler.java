package com.personal.business.payrollcalculation.delete.routes;

import com.personal.business.payrollcalculation.delete.process.DeletePayrollCalculationProcessExecutor;
import com.personal.business.payrollcalculation.entities.PayrollCalculation;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollCalculationHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollCalculation = new PayrollCalculation(id);

        var deletePayrollCalculation = DeletePayrollCalculationProcessExecutor.builder()
                .init(payrollCalculation)
                .execute();

        switch (deletePayrollCalculation.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollCalculation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollCalculation.getInitObject());
        }
    }

}
