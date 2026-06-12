package com.personal.business.payrollcalculation.create.routes;

import com.personal.business.payrollcalculation.create.inputs.PayrollCalculationInput;
import com.personal.business.payrollcalculation.create.process.CreatePayrollCalculationProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollCalculationHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollCalculation = request.content().as(PayrollCalculationInput.class);

        var createPayrollCalculation = CreatePayrollCalculationProcessExecutor.builder()
                .init(payrollCalculation.getPayrollCalculation())
                .execute();
        switch (createPayrollCalculation.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollCalculation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollCalculation.getInitObject());
        }
    }
}
