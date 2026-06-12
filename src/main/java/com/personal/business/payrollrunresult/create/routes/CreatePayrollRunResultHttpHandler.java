package com.personal.business.payrollrunresult.create.routes;

import com.personal.business.payrollrunresult.create.inputs.PayrollRunResultInput;
import com.personal.business.payrollrunresult.create.process.CreatePayrollRunResultProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollRunResultHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollRunResult = request.content().as(PayrollRunResultInput.class);

        var createPayrollRunResult = CreatePayrollRunResultProcessExecutor.builder()
                .init(payrollRunResult.getPayrollRunResult())
                .execute();
        switch (createPayrollRunResult.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollRunResult.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollRunResult.getInitObject());
        }
    }
}
