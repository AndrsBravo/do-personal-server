package com.personal.business.payrollcalculationresult.delete.routes;

import com.personal.business.payrollcalculationresult.delete.process.DeletePayrollCalculationResultProcessExecutor;
import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollCalculationResultHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollCalculationResult = new PayrollCalculationResult(id);

        var deletePayrollCalculationResult = DeletePayrollCalculationResultProcessExecutor.builder()
                .init(payrollCalculationResult)
                .execute();

        switch (deletePayrollCalculationResult.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollCalculationResult.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollCalculationResult.getInitObject());
        }
    }

}
