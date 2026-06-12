package com.personal.management.payrollrun.create.routes;

import com.personal.management.payrollrun.create.inputs.PayrollRunInput;
import com.personal.management.payrollrun.create.process.CreatePayrollRunProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollRunHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollRun = request.content().as(PayrollRunInput.class);

        var createPayrollRun = CreatePayrollRunProcessExecutor.builder()
                .init(payrollRun.getPayrollRun())
                .execute();
        switch (createPayrollRun.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollRun.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollRun.getInitObject());
        }
    }
}
