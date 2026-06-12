package com.personal.business.payrollcalculationresult.create.routes;

import com.personal.business.payrollcalculationresult.create.inputs.PayrollCalculationResultInput;
import com.personal.business.payrollcalculationresult.create.process.CreatePayrollCalculationResultProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollCalculationResultHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollCalculationResult = request.content().as(PayrollCalculationResultInput.class);

        var createPayrollCalculationResult = CreatePayrollCalculationResultProcessExecutor.builder()
                .init(payrollCalculationResult.getPayrollCalculationResult())
                .execute();
        switch (createPayrollCalculationResult.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollCalculationResult.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollCalculationResult.getInitObject());
        }
    }
}
